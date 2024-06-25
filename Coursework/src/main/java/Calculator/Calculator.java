
package Calculator;


import Rooms.Room;
import Works.Work;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Room> map = new HashMap<>();
    private double totalCost = 0;
    private double totalTime = 0;

    public double getTotalCost(){
        return this.totalCost;
    }

    public double getTotalTime(){
        return this.totalTime;
    }

    public void setMap(Map<String, Room> map){
        this.map = map;
    }

    public void calculate(){
        double cost = 0;
        for (Room room : this.map.values()) {
            for (Work work : room.getWorks().values()) {
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
                this.totalCost += work.getCost();
                this.totalTime += work.getTime();
            }
        }
    }

    public void calculateChipWorkTime(double thickness, double area, Work work){
        work.setTime(work.getStandartTime() * area * Math.ceil(thickness/10) / work.getWorkersQuantity());
    }

    public void calculateChipWorkCost(double thickness, double area, Work work){
        work.setCost(work.getPrice() * area * Math.ceil(thickness/10) + work.getTime() * work.getWorkersQuantity() * work.getPrice());
    }

    public void calculateSurfaceWorkTime(double area, Work work){
        work.setTime(work.getStandartTime()*area/work.getWorkersQuantity());
    }

    public void calclulateSurfaceWorkCost(double area, Work work){
        work.setCost(work.getPrice() * area + work.getTime()*work.getWorkersQuantity()*work.getPrice());
    }
}
