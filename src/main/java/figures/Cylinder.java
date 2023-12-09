package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Cylinder extends Figure{
    private boolean onDown = false;
    private boolean isPerp = false;

    public Cylinder(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
        this.isPerp = checkCorner();
    }
    private boolean checkCorner() {
        ArrayList<Integer> h_coord = math.doLineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> downradius_coord = math.doLineCords(Consts.THIRD, Consts.FIRST);

        ArrayList<Integer> topradius_coord = math.doLineCords(Consts.THIRD, Consts.SECOND);

        if (math.countingScalar(h_coord, downradius_coord)) {
            onDown = true;
            return true;
        }

        return math.countingScalar(h_coord, topradius_coord);
    }

    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public String getArea() {
        double h = 0;
        double radius = 0;

        if (onDown) {
            h = math.countLine(Consts.FIRST, Consts.SECOND);
            radius = math.countLine(Consts.FIRST, Consts.THIRD);
        } else {
            h = math.countLine(Consts.FIRST, Consts.SECOND);
            radius = math.countLine(Consts.SECOND, Consts.THIRD);
        }

        return String.format("%.2f", 2 * Math.PI * radius * (radius + h));
    }

    public boolean isValid() {
        return isPerp && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }

}
