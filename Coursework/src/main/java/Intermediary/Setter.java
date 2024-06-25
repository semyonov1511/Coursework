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
            room.addCeiling();
            setRoomParameters(room, key);
            setFloorParameters(room, key);
            setWallsParameters(room,key);
            setCeilingParameters(room,key);
            roomsMap.put(room.getName(), room);
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
        room.setRadiationPower((Double) map.get(key).get("Мощность дозы излучения"));
        room.setRadiationActivity((Double) map.get(key).get("Объемная активность излучения"));
        //return room;
    }
    public void setFloorParameters(Room room, String key){
        room.getFloor().setThickness((Double) map.get(key).get("Толщина пола"));
        room.getFloor().setCoatingMaterial((String) map.get(key).get("Материал покрытия пола"));
        room.getFloor().setContaminationArea((Double) map.get(key).get("Площадь загрязнения пола"));
        room.getFloor().setContaminationDepth((Double) map.get(key).get("Глубина загрязнения пола"));
        room.getFloor().setCoverageArea((Double) map.get(key).get("Площадь покрытия пола"));
    }

    public void setWallsParameters(Room room, String key){
        room.getWalls().setThickness((Double) map.get(key).get("Толщина стен"));
        room.getWalls().setCoatingMaterial((String) map.get(key).get("Материал покрытия стен"));
        room.getWalls().setContaminationArea((Double) map.get(key).get("Площадь загрязнения стен"));
        room.getWalls().setContaminationDepth((Double) map.get(key).get("Глубина загрязнения стен"));
        room.getWalls().setCoverageArea((Double) map.get(key).get("Площадь покрытия стен"));
    }

    public void setCeilingParameters(Room room, String key){
        room.getCeiling().setCoatingMaterial((String) map.get(key).get("Материал покрытия потолка"));
        room.getCeiling().setContaminationArea((Double) map.get(key).get("Площадь загрязнения потолка"));
        room.getCeiling().setContaminationDepth((Double) map.get(key).get("Глубина загрязнения потолка"));
        room.getCeiling().setCoverageArea((Double) map.get(key).get("Площадь покрытия потолка"));
    }


}
