import consts.Consts;

import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            Figure figure = choose();

            if (figure.isFigure()) {
                System.out.println("The figyre is a figure");
                System.out.println("The figure has no area");
                System.out.println("The figure has no perimeter");
            } else if (figure.isValid()) {
                System.out.println("The figyre is valid");
                System.out.println("The figure area " + figure.getArea());
                System.out.println("The figure" + figure.getPerimeter());
            } else {
                System.out.println("The figyre is invalid");
            }

        }
    }

    private static Figure choose() {
        String command = scanner.nextLine();

        while (!command.matches("FIGURE|CIRCLE|SQUARE|RECTANGLE|PARALLELOGRAM|TRIANGLE|POLYGON|SPHERE|TRUNCATED_SPHERE|CYLINDER|CONE")) {
            if (command.equals("END")) {
                System.exit(0);
            } else {
                System.out.println("Please, retype");
                command = scanner.nextLine();
            }

        }

        ArrayList<Point> points = points();

        switch (command) {
            case "CIRCLE":
                return new Circle(points, Consts.TWO_POINT, Consts.TWO_POINT, Consts.THREE_POINT);
            case "SQUARE":
                return new Square(points, Consts.FOUR_POINT, Consts.TWO_POINT, Consts.THREE_POINT);
            case "RECTANGLE":
                return new Rectangle(points, Consts.FOUR_POINT, Consts.TWO_POINT, Consts.THREE_POINT);
            case "TRIANGLE":
                return new Triangle(points, Consts.THREE_POINT, Consts.TWO_POINT, Consts.THREE_POINT);
            case "PARALLELOGRAM":
                return new Parallelogram(points, Consts.FOUR_POINT, Consts.TWO_POINT, Consts.THREE_POINT);
            case "POLYGON":
                return new Polygon(points, points.size() , Consts.TWO_POINT, Consts.THREE_POINT);
            case "SPHERE":
                return new Sphere(points, Consts.TWO_POINT, Consts.THREE_POINT, Consts.THREE_POINT);
            case "TRUNCATED_SPHERE":
                return new TruncatedSphere(points, Consts.THREE_POINT, Consts.THREE_POINT, Consts.THREE_POINT);
            case "CYLINDER":
                return new Cylinder(points, Consts.THREE_POINT, Consts.THREE_POINT, Consts.THREE_POINT);
            case "CONE":
                return new Cone(points, Consts.THREE_POINT, Consts.THREE_POINT, Consts.THREE_POINT);
            default:
                return new Figure();
        }

    }

    private static ArrayList<Point> points() {
        ArrayList<Point> POINTS = new ArrayList<>();

        String coords = scanner.nextLine();

        while (!coords.equals("STOP_INPUT")) {
            if (coords.matches("(-?\\d+ -?\\d+ -?\\d+)|(-?\\d+ -?\\d+)")) {
                String[] p = coords.split(" ");
                POINTS.add(new Point(p));
            } else {
                System.out.println("Please, retype");
            }

            coords = scanner.nextLine();
        }

        return POINTS;
    }
}
