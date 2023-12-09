package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Sphere extends Figure{

    public Sphere(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getPerimeter() {
        return "The figure has no perimeter";

    }

    public String getArea() {
        double radius = math.countLine(Consts.FIRST, Consts.SECOND);
        return String.format("%.2f", 4 * Math.PI * Math.pow(radius, 2));
    }

    public boolean isValid() {
       return super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
