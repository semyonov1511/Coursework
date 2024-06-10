package Parts;

public class Walls extends Part{

    private double thickness;

    public Walls(String material, double area, double thickness) {
        super(material, area);
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }
}
