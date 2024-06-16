package Intermediary;

import Rooms.Room;

import java.util.HashMap;
import java.util.Map;

public class Setter {
    Map<String, Map<String, Object>> map;

    public void setMap(Map<String, Map<String, Object>> map) { this.map = map; }

    public Map<String, Room> setRooms(){
        Map<String, Room> roomsMap = new HashMap<>();
        for (String key : map.keySet()) {
            Room room = new Room();
            room.addFloor();
            room.addWalls();
            setRoomParameters(room, key);
            setFloorParameters(room, key);
        }
        return roomsMap;
    }

    public void setRoomParameters (Room room, String key){
        room.setName(key);
        room.setArea((Double) map.get(key).get("Площадь"));
        room.setHeight((Double) map.get(key).get("Высота"));
        room.setLength((Double) map.get(key).get("Длина"));
        room.setVolume((Double) map.get(key).get("Объем"));
        room.setWidth((Double) map.get(key).get("Ширина"));
        //return room;
    }
    public void setFloorParameters(Room room, String key){
        room.getFloor().setCoverageArea((Double) map.get(key).get("Площадь покрытия пола"));
        room.getWalls().setCoverageArea((Double) map.get(key).get("Площадь покрытия стен"));
        System.out.println("Площадь покрытия пола " + room.getFloor().getCoverageArea());
        System.out.println("Площадь покрытия стен " + room.getWalls().getCoverageArea());
        System.out.println("");
    }


}
