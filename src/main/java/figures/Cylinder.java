package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Cylinder extends Figure {

    private ArrayList<Integer> h_coord = new ArrayList<>();
    private ArrayList<Integer> downradius_coord = new ArrayList<>();
    private ArrayList<Integer> topradius_coord = new ArrayList<>();

    public Cylinder(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }
    private boolean checkCorner() {
        setCoords();

        return math.countingScalar(h_coord, downradius_coord) || math.countingScalar(h_coord, topradius_coord);
    }

    private void setCoords() {
        if (h_coord.isEmpty() && downradius_coord.isEmpty() && topradius_coord.isEmpty()){
            h_coord = math.doLineCords(Consts.FIRST, Consts.SECOND);
            downradius_coord = math.doLineCords(Consts.THIRD, Consts.FIRST);
            topradius_coord = math.doLineCords(Consts.THIRD, Consts.SECOND);
        }
    }


    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public String getArea() {
        double h = 0;
        double radius = 0;

        setCoords();

        if (math.countingScalar(h_coord, downradius_coord)) {
            h = math.countLine(Consts.FIRST, Consts.SECOND);
            radius = math.countLine(Consts.FIRST, Consts.THIRD);
        } else {
            h = math.countLine(Consts.FIRST, Consts.SECOND);
            radius = math.countLine(Consts.SECOND, Consts.THIRD);
        }


        return String.format("%.2f", 2 * Math.PI * radius * (radius + h));
    }

    public boolean isValid() {
        return super.isValid() && checkCorner();
    }

    public boolean isFigure() {
        return false;
    }

}
