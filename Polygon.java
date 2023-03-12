package seminar3;

public abstract class Polygon extends Figures implements Perimeter {
    protected double[] sides;

    protected Polygon(double[] sides) {
        this.sides = sides;
    }

    public Double getPerimeter() {
        Double perimeter = (double) 0;
        for (double side : this.sides) {
            perimeter += side;
        }
        return perimeter;
    }

    abstract Double getArea();

}
