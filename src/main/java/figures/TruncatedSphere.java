package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class TruncatedSphere extends Figure{
    private double radius = 0;
    public TruncatedSphere(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    private void setRadius() {
        if (radius == 0) {
            radius = math.countLine(Consts.FIRST, Consts.SECOND);
        }
    }

    public String getArea() {
        setRadius();
        double truncRadius = Math.sqrt(Math.pow(radius, 2) - Math.pow(dots.get(Consts.THIRD).getZ(), 2));
        double h = radius - dots.get(Consts.THIRD).getZ();
        double truncArea = 2 * Math.PI * radius * h;
        double area = 4 * Math.PI * Math.pow(radius, 2) - truncArea + Math.PI * Math.pow(truncRadius, 2);

        return String.format("%.2f", area);
    }

    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public boolean isValid() {
        if (super.isValid()) {
            setRadius();
            double checkRadius = math.countLine(Consts.FIRST, Consts.THIRD);
            return checkRadius <= radius;
        }

        return false;

    }

    public boolean isFigure() {
        return false;
    }
}
