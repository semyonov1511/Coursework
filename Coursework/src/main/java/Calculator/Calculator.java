
package Calculator;


import Rooms.Room;
import Works.Work;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Room> map = new HashMap<>();
    private double totalCost = 0;
    private double totalTime = 0;
    private double individualDose;
    private double collectiveDose;

    public double getTotalCost(){
        return this.totalCost;
    }

    public double getTotalTime(){
        return this.totalTime;
    }

    public double getIndividualDose(){
        return this.individualDose;
    }

    public double getCollectiveDose(){
        return this.collectiveDose;
    }

    public void setMap(Map<String, Room> map){
        this.map = map;
    }

    public void calculate(){
        int totalWorks = 0;
        for (Room room : this.map.values()) {
            for (Work work : room.getWorks().values()) {
                totalWorks += 1;
                double area = room.getPartArea(work);
                if (work.getType().equals("Поверхностная")){
                    calculateSurfaceWorkTime(area, work);
                    calclulateSurfaceWorkCost(area, work);
                }
                else {
                    double thickness = room.getPartThickness(work);
                    calculateChipWorkTime(thickness, area, work);
                    calculateChipWorkCost(thickness, area, work);
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

    public void calculateChipWorkTime(double thickness, double area, Work work){
        work.setTime(work.getStandartTime() * area * Math.ceil(thickness/10) / work.getWorkersQuantity());
    }

    public void calculateChipWorkCost(double thickness, double area, Work work){
        work.setCost(work.getPrice() * area * Math.ceil(thickness/10) / work.getStandartTime() + work.getTime() * work.getPrice() / work.getStandartTime());
    }

    public void calculateSurfaceWorkTime(double area, Work work){
        work.setTime(work.getStandartTime()*area/work.getWorkersQuantity());
    }

    public void calclulateSurfaceWorkCost(double area, Work work){
        work.setCost(work.getPrice() * area / work.getStandartTime() + work.getTime()  * work.getPrice() / work.getStandartTime());
    }

    public void calculateCollectiveDose(Work work, Room room){
        work.setCollectiveDose(room.getRadiationPower()*work.getTime()*work.getWorkersQuantity());
    }

    public void calculateIndividualDose(Work work, Room room){
        work.setIndividualDose(room.getRadiationPower()*work.getTime());
    }
}
