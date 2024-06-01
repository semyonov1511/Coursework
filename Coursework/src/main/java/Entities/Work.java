package Entities;

public class Work {

    public String name;
    public int standartTime;
    public int workersQuantity;
    public String type;
    public String room;
    public double depth;

    public String getName() {
        return name;
    }

    public int getStandartTime() {
        return standartTime;
    }

    public int getWorkersQuantity() {
        return workersQuantity;
    }

    public String getType() {
        return type;
    }

    public String getRoom() {
        return room;
    }

    public double getDepth() {
        return depth;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setStandartTime(int standartTime) {
        this.standartTime = standartTime;
    }

    public void setWorkersQuantity(int workersQuantity) {
        this.workersQuantity = workersQuantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
