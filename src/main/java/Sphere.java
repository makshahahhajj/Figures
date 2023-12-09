import consts.Consts;

import java.util.ArrayList;

public class Sphere extends Figure{

    public Sphere(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
    }

    public String getPerimeter() {
        return " has no perimeter";

    }

    public String getArea() {
        double radius = countLine(Consts.FIRST, Consts.SECOND, false);
        return String.format("%.2f", 4 * Math.PI * Math.pow(radius, 2));
    }

    public boolean isValid() {
       return super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
