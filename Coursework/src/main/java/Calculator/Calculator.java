
package Calculator;


import Rooms.Room;
import Works.Work;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private double totalCost = 0;
    private double totalTime = 0;
    private double individualDose;
    private double collectiveDose;

    public double getTotalCost() {
        return this.totalCost;
    }

    public double getTotalTime() {
        return this.totalTime;
    }

    public double getIndividualDose() {
        return this.individualDose;
    }

    public double getCollectiveDose() {
        return this.collectiveDose;
    }

    /**
     * Проходит по всем работам всех комнат и для каждой ставит свои посчитанные
     * параметры (стоимость, время, коллективные и индивидуальные дозы
     *
     * @param map - коллекция комнат с привязанными к ним работами
     */
    public void calculate(Map<String, Room> map) {
        int totalWorks = 0;
        collectiveDose = 0;
        individualDose = 0;
        totalCost = 0;
        totalTime = 0;
        for (Room room : map.values()) {
            for (Work work : room.getWorks().values()) {
                totalWorks += 1;
                double area = room.getPartArea(work);
                if (work.getType().equals("Поверхностная")) {
                    calculateSurfaceWorkTime(area, work);
                    calclulateSurfaceWorkCost(area, work);
                } else {
                    double depth = room.getPartDepth(work);
                    calculateChipWorkTime(depth, area, work);
                    calculateChipWorkCost(depth, area, work);
                }
                calculateIndividualDose(work, room);
                calculateCollectiveDose(work, room);
                this.totalCost += work.getCost();
                this.totalTime += work.getTime();
                this.individualDose += work.getIndividualDose();
                this.collectiveDose += work.getCollectiveDose();
            }
        }
        this.individualDose /= totalWorks;
    }

    /**
     * Проводит 10000 экспериментов, для каждого считает коллективные и индивидуальные дозы с учетом нормального
     * распределения мощности дозы излучения и записывает результат в массивы.
     * 
     * @param map - коллекция комнат с привязанными к ним работами
     */
    public void calculateWithDistribution(Map<String, Room> map) {
        int totalWorks;
        double collectiveResults[] = new double[10000];
        double individualResults[] = new double[10000];
        NormalDistribution randomPower = null;
        for (int i = 0; i < 10000; i++) {
            totalWorks = 0;
            collectiveDose = 0;
            individualDose = 0;
            for (Room room : map.values()) {
                randomPower = new NormalDistribution(room.getRadiationPower(), room.getRadiationPower() * 0.05 * room.getRadiationPower());
                for (Work work : room.getWorks().values()) {
                    totalWorks += 1;
                    individualDose += calculateIndividualDose(randomPower.nextNormal(), work);
                    collectiveDose += calculateCollectiveDose(randomPower.nextNormal(), work);
                }
            }
            individualDose /= totalWorks;
            collectiveResults[i] = collectiveDose;
            individualResults[i] = individualDose;
        }

        randomPower.createHistogram("Collective dose distribution", collectiveResults);
        randomPower.createHistogram("Individual dose distribution", individualResults);
    }

    private void calculateChipWorkTime(double depth, double area, Work work) {
        work.setTime(work.getStandartTime() * area * Math.ceil(depth / 10) / work.getWorkersQuantity());
    }

    private void calculateChipWorkCost(double depth, double area, Work work) {
        work.setCost(work.getPrice() * area * Math.ceil(depth / 10) / work.getStandartTime() + work.getTime() * work.getPrice() / work.getStandartTime());
    }

    private void calculateSurfaceWorkTime(double area, Work work) {
        work.setTime(work.getStandartTime() * area / work.getWorkersQuantity());
    }

    private void calclulateSurfaceWorkCost(double area, Work work) {
        work.setCost(work.getPrice() * area / work.getStandartTime() + work.getTime() * work.getPrice() / work.getStandartTime());
    }

    private void calculateCollectiveDose(Work work, Room room) {
        work.setCollectiveDose(room.getRadiationPower() * work.getTime() * work.getWorkersQuantity());
    }

    private void calculateIndividualDose(Work work, Room room) {
        work.setIndividualDose(room.getRadiationPower() * work.getTime());
    }

    private double calculateIndividualDose(double power, Work work) {
        return (power * work.getTime());
    }

    private double calculateCollectiveDose(double power, Work work) {
        return (power * work.getTime() * work.getWorkersQuantity());
    }

}
