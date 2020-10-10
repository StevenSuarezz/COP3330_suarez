public class Cube extends Shape3D {
    private double length;

    public Cube(double length) {
        this.length = length;
        name = "cube";
    }

    @Override
    public double getVolume() {
        return length * length * length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return 6 * length * length;
    }
}
