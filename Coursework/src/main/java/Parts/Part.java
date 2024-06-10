package Parts;

import Materials.Material;

import java.util.ArrayList;

public class Part {
    ArrayList<Material> partsList;
    private String material;
    private double area;

    public Part(String material, double area) {
        this.material = material;
        this.area = area;
    }

    public String getMaterial() {
        return material;
    }

    public double getArea() {
        return area;
    }
}
