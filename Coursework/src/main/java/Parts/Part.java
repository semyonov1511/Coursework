package Parts;

import Materials.Material;

import java.util.ArrayList;

public class Part {
    private String material; // материал
    private String coatingMaterial; // материал покрытия
    private double thickness; // толщина
    private double contaminationArea; // площадь загрязнения
    private double contaminationDepth; // глубина загрязнения
    private double coverageArea; // площадь покрытия


    public String getCoatingMaterial() {
        return this.coatingMaterial;
    }

    public void setCoatingMaterial(String coatingMaterial) {
        this.coatingMaterial = coatingMaterial;
    }

    public double getContaminationArea() {
        return this.contaminationArea;
    }

    public void setContaminationArea(double contaminationArea) {
        this.contaminationArea = contaminationArea;
    }

    public double getContaminationDepth() {
        return this.contaminationDepth;
    }

    public void setContaminationDepth(double contaminationDepth) {
        this.contaminationDepth = contaminationDepth;
    }

    public double getCoverageArea() {
        return this.coverageArea;
    }

    public void setCoverageArea(double coverageArea) {
        this.coverageArea = coverageArea;
    }
}
