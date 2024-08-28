package task2;

public class Rectangle extends Figure {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public double getSquare() {
        return this.length * this.width;
    }

    @Override
    public String toString() {
        return "Your figure is Rectangle" +
                "\nIts sides are equal: " +
                "\nLength =" + this.length +
                "\nWidth =" + this.width +
                "\nIts perimeter is: " + getPerimeter() +
                "\nIts square is: " + getSquare();
    }
}
