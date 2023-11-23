import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            ArrayList<Point> points = points();

            Figure figure = choose(command, points);
            if (figure == null && command.equals("FIGURE")) {
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

            command = scanner.nextLine();
        }
    }

    private static Figure choose(String command, ArrayList<Point> points) {
        switch (command) {
            case "CIRCLE":
                return new Circle(points, CONSTS.TWO_POINT, CONSTS.TWO_POINT, CONSTS.THREE_POINT);
            case "SQUARE":
                return new Square(points, CONSTS.FOUR_POINT, CONSTS.TWO_POINT, CONSTS.THREE_POINT);
            case "RECTANGLE":
                return new Rectangle(points, CONSTS.FOUR_POINT, CONSTS.TWO_POINT, CONSTS.THREE_POINT);
            case "TRIANGLE":
                return new Triangle(points, CONSTS.THREE_POINT, CONSTS.TWO_POINT, CONSTS.THREE_POINT);
            case "PARALLELOGRAM":
                return new Parallelogram(points, CONSTS.FOUR_POINT, CONSTS.TWO_POINT, CONSTS.THREE_POINT);
            case "POLYGON":
                return new Polygon(points, points.size() , CONSTS.TWO_POINT, CONSTS.THREE_POINT);
            case "SPHERE":
                return new Sphere(points, CONSTS.TWO_POINT, CONSTS.THREE_POINT, CONSTS.THREE_POINT);
            case "TRUNCATED_SPHERE":
                return new TruccatedSphere(points, CONSTS.THREE_POINT, CONSTS.THREE_POINT, CONSTS.THREE_POINT);
            case "CYLINDER":
                return new Cylinder(points, CONSTS.THREE_POINT, CONSTS.THREE_POINT, CONSTS.THREE_POINT);
            case "CONE":
                return new Cone(points, CONSTS.THREE_POINT, CONSTS.THREE_POINT, CONSTS.THREE_POINT);
            case "FIGURE":
                return null;
            default:
                return null;
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
