package Parts;

public class Floor extends Part {
    private double thickness;
    private String material;

    public double getThickness() {
        return this.thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
}
