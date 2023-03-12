package seminar3;

import java.util.ArrayList;
import java.util.Collections;


public class CollectoinsFigures {
    static ArrayList<Figures> allFigure = new ArrayList<>();
    {
        allFigure.add(new Circle(5.0));
        allFigure.add(new Circle(12.0));
        allFigure.add(new Circle(11.0));
        allFigure.add(new Circle(5.0));
        allFigure.add(new Rectangle(12.0, 15.0));
        allFigure.add(new Rectangle(1.0, 4.0));
        allFigure.add(new Square(13.0));
        allFigure.add(new Square(5.0));
        allFigure.add(new Square(17.0));
        allFigure.add(new Triangle(15.0, 5.5, 11.0));
        allFigure.add(new Triangle(6.0, 7.0, 2.0));
        allFigure.add(new Triangle(11.3, 5.1, 8.1));
    }

    public int size() {

        return allFigure.size() + 1;
    }

    public static void getAllParametr() {

        getAllArea(allFigure);

        getAllPerimetr(allFigure);

        getcircumferenceLength(allFigure);

    }

    public static void getAllPerimetr(ArrayList<Figures> allFigure) {
        Double perimetr = (double) 0;
        int count = 0;
        for (Figures figure : allFigure) {
            if (figure instanceof Perimeter) {
                count++;
                perimetr += ((Polygon) figure).getPerimeter();
            }
        }
        System.out.printf("Периметр всех %d фигур = %.2f \n", count, perimetr);
    }

    public static void getAllArea(ArrayList<Figures> allFigure) {
        Double area = (double) 0;
        int count = 0;
        for (int index = 0; index < allFigure.size(); index++) {
            count++;
            area += ((Figures) allFigure.get(index)).getArea();
        }
        System.out.printf("Площадь всех %d фигур = %.2f \n", count, area);
    }

    public static void getcircumferenceLength(ArrayList<Figures> allFigure) {
        Double circumferenceLength = (double) 0;
        int count = 0;
        for (Figures figure : allFigure) {
            if (figure instanceof Circle) {
                count++;
                circumferenceLength += ((Circle) figure).getCircumferenceLength();
            }
        }
        System.out.printf("Сумма длин всех %d фигур = %.2f \n", count, circumferenceLength);
    }

    public static void showAllFigures() {
        // Collections.sort(allFigure);
        int count = 1;
        for (Figures figur : allFigure) {
            System.out.printf("%d. ", count);
            System.out.println(figur);
            System.out.println("---");
            count++;
        }
    }
    public static void sortAllFigures(){
        Collections.sort(allFigure);
        int count = 1;
        for (Figures figur : allFigure) {
            System.out.printf("%d. ", count);
            System.out.println(figur);
            System.out.println("---");
            count++;
        }

    }
    





}
