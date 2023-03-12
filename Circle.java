package seminar3;

import java.util.Comparator;

public class Circle extends Figures implements CircumferenceLength {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;

    }

    Double getArea() {

        return Math.PI * radius * radius;
    }

    @Override
    public Double getCircumferenceLength() {
        return 2 * Math.PI * radius;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Круг: площадь  - %.2f; радиус %.2f; окружность %.2f", getArea(), radius,
                getCircumferenceLength());
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
