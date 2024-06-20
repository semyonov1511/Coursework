package Rooms;

import Parts.*;
import Works.Work;

import java.util.HashMap;
import java.util.Map;

public class Room {
    Map<String, Part> partsMap = new HashMap<>();
    Map<String, Work> worksMap = new HashMap<>();
    private String name;
    private double length;
    private double width;
    private double height;
    private double area;
    private double volume;
    private double radiationPower;
    private double radiationActivity;

    public void addWork(Work work){
        worksMap.put(work.getName(),work);
    }

    public Map<String, Work> getWorks(){
        return worksMap;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getRadiationPower() {
        return radiationPower;
    }

    public void setRadiationPower(double radiationPower) {
        this.radiationPower = radiationPower;
    }

    public double getRadiationActivity() {
        return radiationActivity;
    }

    public void setRadiationActivity(double radiationActivity) {
        this.radiationActivity = radiationActivity;
    }

    public void addFloor(){
        partsMap.put("Пол",new Floor());
    }

    public void addWalls(){
        partsMap.put("Стены",new Walls());
    }

    public void addCeiling(){
        partsMap.put("Потолок",new Ceiling());
    }

    public Floor getFloor(){
        return (Floor) partsMap.get("Пол");
    }

    public Walls getWalls(){
        return (Walls) partsMap.get("Стены");
    }

    public Ceiling getCeiling(){
        return (Ceiling) partsMap.get("Потолок");
    }

}
