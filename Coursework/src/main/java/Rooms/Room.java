package Rooms;

import Parts.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
    Map<String, Part> partsMap = new HashMap<>();;
    private double length;
    private double width;
    private double height;
    private double area;
    private double volume;
    private double wallThickness;
    private double floorThickness;
    private double radiationPower;
    private double radiationActivity;

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

    public void addFloor(String material, double area, double thickness){
        partsMap.put("Пол",new Floor(material, area, thickness));
    }

    public void addWalls(String material, double area, double thickness){
        partsMap.put("Стены",new Walls(material, area, thickness));
    }

    public void addCeiling(String material, double area){
        partsMap.put("Потолок",new Ceiling(material, area));
    }

}
