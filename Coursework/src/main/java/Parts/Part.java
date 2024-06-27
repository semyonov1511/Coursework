package Parts;

import Works.Work;

import java.util.ArrayList;

public class Part {
    private String coatingMaterial; // материал покрыт
    private double contaminationArea; // площадь загрязнения
    private double contaminationDepth; // глубина загрязнения
    private double coverageArea; // площадь покрытия
    private ArrayList<Work> worksList;

    public void setWorksList(ArrayList<Work> worksList){
        this.worksList = worksList;
    }

    public ArrayList<Work> getWorksList(){
        return this.worksList;
    }

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
