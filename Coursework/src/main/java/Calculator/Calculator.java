
package Calculator;


import Rooms.Room;
import Works.Work;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Room> map = new HashMap<>();

    public void setMap(Map<String, Room> map){
        this.map = map;
    }

    public double calculatePrice(){
        double cost = 0;
        for (Room room : this.map.values()) {
            for (Work work : room.getWorks().values()) {
                double area = room.getPartArea(work);
                if (work.getType().equals("Поверхностная")){
                    calculateSurfaceWorkTime(area, work);
                    calclulateSurfaceWorkCost(area, work);
                    cost += work.getCost();
                }
                else {
                    calculateChipWorkTime(area, work);
                    calculateChipWorkCost(area, work);
                }
            }
        }
        return cost;
    }

    public void calculateChipWorkTime(double area, Work work){
        work.setTime(work.getStandartTime()*area/work.getWorkersQuantity());
    }

    public void calculateChipWorkCost(double area, Work work){
        work.setCost(work.getPrice() * area + work.getTime()*work.getWorkersQuantity()*work.getPrice());
    }

    public void calculateSurfaceWorkTime(double area, Work work){
        work.setTime(work.getStandartTime()*area/work.getWorkersQuantity());
    }

    public void calclulateSurfaceWorkCost(double area, Work work){
        work.setCost(work.getPrice() * area + work.getTime()*work.getWorkersQuantity()*work.getPrice());
    }
}
