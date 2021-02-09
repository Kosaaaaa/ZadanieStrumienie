public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return Math.pow(this.side, 2);
    }

    public double getPerimeter() {
        return 4 * this.side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side + ", " +
                "area=" + this.getArea() + ", " +
                "perimeter=" + this.getPerimeter() +
                '}';
    }
}
