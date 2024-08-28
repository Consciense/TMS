package task2;

public class Triangle extends Figure {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @Override
    public double getSquare() {
        double halfOfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - this.sideA) *
                (halfOfPerimeter - this.sideB) * (halfOfPerimeter - this.sideC));
    }

    @Override
    public String toString() {
        return "Your figure is Triangle" +
                "\nIts sides are equal: "+
                "\nSide A =" + this.sideA +
                "\nSide B =" + this.sideB +
                "\nSide C =" + this.sideC +
                "\nIts perimeter is: " + getPerimeter() +
                "\nIts square is: " + getSquare();
    }
}
