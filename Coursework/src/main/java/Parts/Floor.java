package Parts;

public class Floor extends Part {
    private double thickness;

    public Floor(String material, double area, double thickness) {
        super(material, area);
        this.thickness = thickness;
    }

    public double getThickness() {
        return thickness;
    }
}
