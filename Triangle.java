package seminar3;

public class Triangle extends Polygon {

    protected Triangle(double a, double b, double c) {
        super(new double[] { a, b, c });

    }

    @Override
    Double getArea() {
        double halfPerimeter = super.getPerimeter() / 2;
        return Math.sqrt(
                halfPerimeter * (halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) * (halfPerimeter - sides[1]));
    }

    public Double getPerimeter() {
        return super.getPerimeter();

    }

    @Override
    public String toString() {
        return String.format("Треугольник: площадь  - %.2f; периметр %.2f, сторона а =%.2f,сторона b =%.2f, сторона c =%.2f  ", getArea(), getPerimeter(),sides[0],sides[1], sides[2]);
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
