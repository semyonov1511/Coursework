package Intermediary;

import Rooms.Room;
import Works.Work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    ArrayList<Work> worksList = new ArrayList<Work>();
    Map<String, Room> objectsMap = new HashMap<>();

    public void setWorksList(ArrayList<Work> list) {
        this.worksList = list;
    }

    public ArrayList<Work> getWorksList(){
        return this.worksList;
    }

    public void setObjectsMap(Map<String, Room> objectsMap) {
        this.objectsMap = objectsMap;
    }

    public Map<String, Room> getObjectsMap(){
        return this.objectsMap;
    }
}
