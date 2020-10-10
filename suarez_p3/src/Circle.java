public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        name = "circle";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
