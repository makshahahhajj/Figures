package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Square extends Figure {
    private double line = 0;

    public Square(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
        this.line = math.countLine(Consts.FIRST, Consts.SECOND);
    }

    private boolean checkCorner() {
        ArrayList<Integer> width= math.doLineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> height = math.doLineCords(Consts.THIRD, Consts.SECOND);
        return math.countingScalar(width, height);
    }

    public String getArea() {
        return String.format("%.2f", Math.pow(line, 2));
    }

    public  String getPerimeter() {
        return String.format("%.2f", line * 4);
    }

    public  boolean isValid() {
        double firstLine = line;
        double secondLine = math.countLine(Consts.FOURTH, Consts.FIRST);

        for (int i = 1; i < dots.size() - 1; ++i) {
            double l = math.countLine(i, i + 1);
            if (firstLine != l) {
                return false;
            }
        }

        return checkCorner() && (firstLine == secondLine) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
