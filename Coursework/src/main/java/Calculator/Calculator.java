
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
                if (work.getType().equals("Поверхностная")){
                    calculateSurfaceWorkTime(room, work);
                    calclulateSurfaceWorkCost(room, work);
                    cost += work.getCost();
                }
                else {
                    calculateChipWorkTime(room, work);
                    calculateChipWorkCost(room, work);
                }
            }
        }
        return cost;
    }

    public void calculateSurfaceWorkTime(Room room, Work work){
        double area = getPartArea(room, work);
        work.setTime(work.getStandartTime()*area/work.getWorkersQuantity());
    }

    public void calclulateSurfaceWorkCost(Room room, Work work){
        double area = getPartArea(room, work);
        work.setCost(work.getPrice() * area + work.getTime()*work.getWorkersQuantity()*work.getPrice());
    }

    public double getPartArea(Room room, Work work){
        switch (work.getPart()){
            case "Пол" -> {
                return room.getFloor().getCoverageArea();
            }
            case "Потолок" -> {
                return room.getCeiling().getCoverageArea();
            }
            case "Стены" -> {
                return room.getWalls().getCoverageArea();
            }
            default -> {
                return 0;
            }
        }
    }
}
