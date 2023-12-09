package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Rectangle extends Figure{
    private double lineOne = 0;
    private double lineTwo  = 0;

    public Rectangle(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
        this.lineOne = math.countLine(Consts.FIRST, Consts.SECOND);
        this.lineTwo = math.countLine(Consts.SECOND, Consts.THIRD);;
    }

    private boolean checkCorner() {
        ArrayList<Integer> width = math.doLineCords(Consts.FIRST, Consts.SECOND);
        ArrayList<Integer> height = math.doLineCords(Consts.THIRD, Consts.SECOND);
        return math.countingScalar(width, height);
    }
    public String getArea() {
        return String.format("%.2f", lineOne * lineTwo);
    }

    public  String getPerimeter() {
        return String.format("%.2f", 2 * (lineTwo + lineOne));
    }

    public  boolean isValid() {
        double line1 = lineOne;
        double line2 = lineTwo;
        double line3 = math.countLine(Consts.THIRD, Consts.FOURTH);
        double line4 = math.countLine(Consts.FOURTH, Consts.FIRST);


        return checkCorner() && !(line1 != line3 || line2 != line4 || line1 == line2) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
