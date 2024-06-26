package Works;

public class Work {

    public String name;
    public double time;
    public int standartTime;
    public int workersQuantity;
    public String type;
    public String room;
    public double depth;
    public int price;
    public String part;
    public double cost;
    private double collectiveDose;
    private double individualDose;

    public double getCollectiveDose() { return collectiveDose; }

    public double getIndividualDose() { return individualDose; }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
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

    public double getCost() { return cost; }

    public String getRoom() {
        return room;
    }

    public double getDepth() {
        return depth;
    }

    public int getPrice() { return price; }

    public String getPart() { return part; }

    public void setPart(String part) {
        this.part = part;
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

    public void setPrice(int price){
        this.price = price;
    }

    public void setTime(double time) { this.time = time; }

    public void setCost(double cost) { this.cost = cost; }

    public void setCollectiveDose(double collectiveDose) {
        this.collectiveDose = collectiveDose;
    }

    public void setIndividualDose(double individualDose) {
        this.individualDose = individualDose;
    }

}
