package Rooms;

import Parts.*;

import java.util.ArrayList;

public class Room {
    ArrayList<Part> partsList;

    public void addFloor(){
        partsList.add(new Floor());
    }
    public void addWalls(){
        partsList.add(new Walls());
    }
    public void addCeiling(){
        partsList.add(new Floor());
    }

}
