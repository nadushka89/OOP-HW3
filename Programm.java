package seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Programm {
    public static void main(String[] args) {
        CollectoinsFigures allFig = new CollectoinsFigures();
        Scanner input = new Scanner(System.in);
        menu(input, getAllFigures());
        input.close();
    }

    public static ArrayList<Figures> getAllFigures() {
        return CollectoinsFigures.allFigure;
    }

    public static void menu(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("Выберите необходимый пункт меню: ");
        System.out.println("1. Добавление новой фигуры.");
        System.out.println("2. Посчитать периметр у всех фигур.");
        System.out.println("3. Посчитать площадь у всех фигур.");
        System.out.println("4. Вывод информации о всех периметах, площадях и длинах окружности всех фигур.");
        System.out.println("5. Удаление фигуры.");
        System.out.println("6. Изменения фигуры по индексу.");
        System.out.println("7. Сортировки по площади, вывод информации о всех фигурах.");
        System.out.println("8. Показать все фигуры.");
        System.out.println("Введите №: ");
        int answer = input.nextInt();
        System.out.println();
        switch (answer) {
            case 1:
                createFigure(input, allFigure);
                menu(input, allFigure);
            case 2:
                CollectoinsFigures.getAllPerimetr(allFigure);
                menu(input, allFigure);
            case 3:
                CollectoinsFigures.getAllArea(allFigure);
                menu(input, allFigure);
            case 4:
                CollectoinsFigures.getAllParametr();
                menu(input, allFigure);
            case 5:
                deleteFigure(input, allFigure);
                menu(input, allFigure);
            case 6:
                changeFigure(input, allFigure);
                menu(input, allFigure);

            case 7:
                CollectoinsFigures.sortAllFigures();
                menu(input, allFigure);
            case 8:
                CollectoinsFigures.showAllFigures();
                menu(input, allFigure);

        }
    }

    private static void createFigure(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("Выберите необходимый пункт меню: ");
        System.out.println("1. Создать круг.");
        System.out.println("2. Создать треугольник.");
        System.out.println("3. Создать прямоугольник.");
        System.out.println("4. Создать квадрат.");
        System.out.println("5. Назад в главное меню.");
        System.out.println("Введите №: ");
        int answer = input.nextInt();
        System.out.println();
        switch (answer) {
            case 1:
                createCircle(input, allFigure);
                createFigure(input, allFigure);
            case 2:
                createTriangle(input, allFigure);
                createFigure(input, allFigure);
            case 3:
                createRectangle(input, allFigure);
                createFigure(input, allFigure);
            case 4:
                createSquare(input, allFigure);
                createFigure(input, allFigure);
            case 5:
                menu(input, allFigure);
        }
    }

    private static void createCircle(Scanner input, ArrayList<Figures> allFigure) {
        System.out.print("Введите радиус круга: ");
        Double radius = input.nextDouble();
        if (!(radius > 0)) {
            System.out.print("Такого круга нет\n");
            createFigure(input, allFigure);
        } else {
            allFigure.add(new Circle(radius));
        }

    }

    private static void createTriangle(Scanner input, ArrayList<Figures> allFigure) {
        System.out.print("Введите сторону a: ");
        Double a = input.nextDouble();
        System.out.print("Введите сторону b: ");
        Double b = input.nextDouble();
        System.out.print("Введите сторону c: ");
        Double c = input.nextDouble();
        if (!((a + b) > c && (b + c) > a && (c + a) > b)) {
            System.out.print("Треугольник с такими сторонами не существует\n");
            createFigure(input, allFigure);
        } else {
            allFigure.add(new Triangle(a, b, c));
        }
    }

    private static void createRectangle(Scanner input, ArrayList<Figures> allFigure) {
        System.out.print("Введите сторону a: ");
        Double a = input.nextDouble();
        System.out.print("Введите сторону b: ");
        Double b = input.nextDouble();
        if (!(a > 0 && b > 0)) {
            System.out.print("Такого прямоугольника нет\n");
            createFigure(input, allFigure);
        } else {
            allFigure.add(new Rectangle(a, b));
        }

    }

    private static void createSquare(Scanner input, ArrayList<Figures> allFigure) {
        System.out.print("Введите сторону a: ");
        Double a = input.nextDouble();
        if (!(a > 0)) {
            System.out.print("Такого квадрата нет\n");
            createFigure(input, allFigure);
        } else {
            allFigure.add(new Square(a));
        }

    }

    private static void deleteFigure(Scanner input, ArrayList<Figures> allFigure) {
        CollectoinsFigures.showAllFigures();
        System.out.print("Какую фигуру хотите удалить?: ");
        int answer = input.nextInt();
        if (answer <= allFigure.size() + 1) {
            allFigure.remove(answer - 1);
            System.out.println("Фигура успешно удалена");
        } else {
            System.out.println("Фигура не удалена");
        }
    }

    private static void changeFigure(Scanner input, ArrayList<Figures> allFigure) {
        CollectoinsFigures.showAllFigures();
        System.out.print("Какую фигуру хотите изменить?: ");
        int answer = input.nextInt();
        Figures f = allFigure.get(answer - 1);
        if (f instanceof Circle) {
            System.out.print("Введите радиус круга: ");
            Double value1 = input.nextDouble();
            if (!(value1 > 0)) {
                System.out.print("Такого круга нет\n");
            } else {
                f = new Circle(value1);
                allFigure.set(answer - 1, f);
            }
        } else if (f instanceof Triangle) {
            System.out.print("Введите сторону a: ");
            Double value1 = input.nextDouble();
            System.out.print("Введите сторону b: ");
            Double value2 = input.nextDouble();
            System.out.print("Введите сторону c: ");
            Double value3 = input.nextDouble();
            if (!((value1 + value2) > value3 && (value2 + value3) > value1 && (value3 + value1) > value2)) {
                System.out.print("Треугольник с такими сторонами не существует\n");
            } else {
                f = new Triangle(value1, value2, value3);
                allFigure.set(answer - 1, f);
            }
        } else if (f instanceof Rectangle) {
            System.out.print("Введите сторону a: ");
            Double value1 = input.nextDouble();
            System.out.print("Введите сторону b: ");
            Double value2 = input.nextDouble();
            if (!(value1 > 0 && value2 > 0)) {
                System.out.print("Такого прямоугольника нет\n");
            } else {
                f = new Rectangle(value1, value2);
                allFigure.set(answer - 1, f);
            }

        } else if (f instanceof Square) {
            System.out.print("Введите сторону a: ");
            Double value1 = input.nextDouble();
            if (!(value1 > 0)) {
                System.out.print("Такого квадрата нет\n");
            } else {
                f = new Square(value1);
                allFigure.set(answer - 1, f);
            }

        } else {
            System.out.print("Что-то пошло не так... ");
        }
        System.out.println("Фигура успешно изменена");

    }
}