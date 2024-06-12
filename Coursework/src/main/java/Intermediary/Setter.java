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
            setRoomParameters(room, key);
            System.out.println("Параметры комнаты " + room.getName() + ": Длина " + room.getLength() + " Объем " + room.getVolume());
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


}
