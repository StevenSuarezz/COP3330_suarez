public class Triangle extends Shape2D {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        name = "triangle";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}
