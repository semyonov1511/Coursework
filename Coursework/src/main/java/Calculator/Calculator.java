
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
        double price = 0;
        for (Room room : this.map.values()) {
            for (Work work : room.getWorks().values()) {
                if (work.getType().equals("Поверхностная")){
                    calclulateSurfaceWorkCost(room, work);
                }
            }
        }
        return price;
    }

    public double calclulateSurfaceWorkCost(Room room, Work work){
        double area = 0;
        System.out.println("Комната работы " + work.getRoom() + " " + work.getPart());
        switch (work.getPart()){
            case "Пол" -> {
                area = room.getFloor().getCoverageArea();
            }
            case "Потолок" -> area = room.getCeiling().getCoverageArea();
            case "Стены" -> area = room.getWalls().getCoverageArea();
        }
        return work.getPrice() * area + ;
    }
}
