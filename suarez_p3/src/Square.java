public class Square extends Shape2D {
    private double length;

    public Square(double length) {
        this.name = "square";
        this.length = length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return length * length;
    }
}
