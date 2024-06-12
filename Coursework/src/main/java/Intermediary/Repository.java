package Intermediary;

import Works.Work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    Setter setter = new Setter();
    ArrayList<Work> worksList = new ArrayList<Work>();
    Map<String, Map<String, Object>> objectsMap = new HashMap<>();

    public void setWorksList(ArrayList<Work> list){
        this.worksList = list;
    }
    public void setObjectsMap(Map<String, Map<String, Object>> objectsMap){
        this.objectsMap = objectsMap;
        setter.setMap(objectsMap);
        setter.setRooms();
    }
    public void addWork(Work work){
        worksList.add(work);
    }

}
