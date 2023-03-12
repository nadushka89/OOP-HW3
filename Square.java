package seminar3;

public class Square extends Polygon {

    protected Square(double a) {
        super(new double[] { a, a, a, a });
        // if (a<=0){
        // throw new Exception("Такого квадрата нет");
        // }

    }

    @Override
    Double getArea() {
        return sides[0] * sides[0];
    }

    @Override
    public Double getPerimeter() {

        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return String.format("Квадрат: площадь  - %.2f; периметр %.2f, сторона: %.2f", getArea(), getPerimeter(),
                sides[0]);
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
