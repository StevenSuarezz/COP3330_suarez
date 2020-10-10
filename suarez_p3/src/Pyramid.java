public class Pyramid extends Shape3D {
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        name = "pyramid";
    }

    @Override
    public double getVolume() {
        return (length * width * height) / 3;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double part1 = length * width;
        double part2 = length * Math.sqrt(Math.pow(width/2, 2) + height * height);
        double part3 = width * Math.sqrt(Math.pow(length/2, 2) + height * height);

        return part1 + part2 + part3;
    }
}
