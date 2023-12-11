package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Circle extends Figure {
    private double radius = 0;

    public Circle(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    @Override
    public String getArea() {
        setRadius();
        double area = Math.PI * Math.pow(radius, 2);
        return String.format("%.2f", area);
    }

    @Override
    public String getPerimeter() {
        setRadius();
        double per = 2 * Math.PI * radius;
        return String.format("%.2f", per);
    }

    private void setRadius() {
        if (radius == 0) {
            radius = math.countLine(Consts.FIRST, Consts.SECOND);
        }
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

    @Override
    public boolean isFigure() {
        return false;
    }
}
