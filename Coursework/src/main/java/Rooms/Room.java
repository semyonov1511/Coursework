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
    private int storey;

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

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
        partsMap.put("Пол",new ExtendedPart());
    }

    public void addWalls(){
        partsMap.put("Стены",new ExtendedPart());
    }

    public void addCeiling(){
        partsMap.put("Потолок",new Part());
    }

    public ExtendedPart getFloor(){
        return (ExtendedPart) partsMap.get("Пол");
    }

    public ExtendedPart getWalls(){
        return (ExtendedPart) partsMap.get("Стены");
    }

    public Part getCeiling(){
        return (Part) partsMap.get("Потолок");
    }

    public double getPartArea(Work work){
        switch (work.getPart()){
            case "Пол" -> {
                return getFloor().getCoverageArea();
            }
            case "Потолок" -> {
                return getCeiling().getCoverageArea();
            }
            case "Стены" -> {
                return getWalls().getCoverageArea();
            }
            default -> {
                return 0;
            }
        }
    }
    public double getPartDepth(Work work){
        switch (work.getPart()){
            case "Потолок" -> {
                return getCeiling().getContaminationDepth();
            }
            case "Стены" -> {
                return getWalls().getContaminationDepth();
            }
            default -> {
                return 0;
            }
        }
    }



}
