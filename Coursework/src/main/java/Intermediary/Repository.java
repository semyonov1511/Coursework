package Intermediary;

import Rooms.Room;
import Works.Work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    Setter setter = new Setter();
    ArrayList<Work> worksList = new ArrayList<Work>();
    Map<String, Room> objectsMap = new HashMap<>();

    public void setWorksList(ArrayList<Work> list) {
        this.worksList = list;
    }

    public ArrayList<Work> getWorksList(){
        return this.worksList;
    }

    public void setObjectsMap(Map<String, Map<String, Object>> objectsMap) {
        setter.setMap(objectsMap);
        this.objectsMap = setter.setRooms();
    }

    public void addWork(Work work) {
        worksList.add(work);
    }

    public Map<String, Room> getObjectsMap(){
        return this.objectsMap;
    }
}
