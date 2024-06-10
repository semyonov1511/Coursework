package Intermediary;

import Works.Work;

import java.util.ArrayList;

public class Repository {
    ArrayList<Work> list = new ArrayList<Work>();

    public void setList(ArrayList<Work> list){
        this.list = list;
    }
    public void addWork(Work work){
        list.add(work);
    }

}
