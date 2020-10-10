public class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
        name = "sphere";
    }

    @Override
    public double getVolume() {
        return (4.0/3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }
}
