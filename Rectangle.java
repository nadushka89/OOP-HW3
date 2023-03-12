package seminar3;

public class Rectangle extends Polygon {

    protected Rectangle(double a, double b) {
        super(new double[] { a, b });
        // if (a<=0 && b<=0){
        // throw new Exception("Такого прямоугольника нет");
        // }

    }

    @Override
    Double getArea() {
        return sides[0] * sides[1];
    }

    @Override
    public Double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник: площадь  - %.2f; периметр %.2f, стороны: %.2f , %.2f", getArea(),
                getPerimeter(),
                sides[0], sides[1]);

    }

    @Override
    public int compareTo(Figures o) {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

}
