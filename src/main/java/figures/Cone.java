package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Cone extends Figure {

    public Cone(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    private boolean checkCorner() {
        ArrayList<Integer> h_coord = math.doLineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> radius_coord = math.doLineCords(Consts.THIRD, Consts.FIRST);
        return math.countingScalar(h_coord, radius_coord);

    }

    public String getArea() {
        double radius = math.countLine(Consts.FIRST, Consts.SECOND);
        double h = math.countLine(Consts.SECOND, Consts.THIRD);
        return String.format("%.2f", Math.PI * radius * (h + radius));
    }

    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public boolean isValid() {
        return super.isValid() && checkCorner();
    }

    public boolean isFigure() {
        return false;
    }
}
