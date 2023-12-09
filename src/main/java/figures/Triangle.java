package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Triangle extends Figure{

    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;

    public Triangle(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
        this.line1 = math.countLine(Consts.FIRST, Consts.SECOND);
        this.line2 = math.countLine(Consts.SECOND, Consts.THIRD);
        this.line3 = math.countLine(Consts.THIRD, Consts.FIRST);
    }

    public String getArea() {
        double per = (line1 + line2 + line3) / 2;
        return String.format("%.2f", Math.sqrt(per * (per - line1) * (per - line2) * (per - line3)));

    }

    public double getAreaDouble() {
        isValid();
        double per = (line1 + line2 + line3) / 2;
        return Math.sqrt(per * (per - line1) * (per - line2) * (per - line3));
    }

    public  String getPerimeter() {
        return String.format("%.2f", line1 + line2 + line3);
    }

    public boolean isValid() {
        return (line1 < line2 + line3 && line2 < line1 + line3 && line3 < line1 + line2) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }

}
