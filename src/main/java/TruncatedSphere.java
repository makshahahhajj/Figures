import com.sun.tools.jconsole.JConsoleContext;
import consts.Consts;

import java.util.ArrayList;

public class TruncatedSphere extends Figure{
    private double radius = 0;
    public TruncatedSphere(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
    }

    public String getArea() {
        double truncRadius = Math.sqrt(Math.pow(radius, 2) - Math.pow(dots.get(Consts.THIRD).getZ(), 2));
        double h = radius - dots.get(Consts.THIRD).getZ();
        double truncArea = 2 * Math.PI * radius * h;
        double area = 4 * Math.PI * Math.pow(radius, 2) - truncArea + Math.PI * Math.pow(truncRadius, 2);

        return String.format("%.2f", area);
    }

    public String getPerimeter() {
        return " has no perimeter";
    }

    public boolean isValid() {
        double checkRadius = countLine(Consts.FIRST, Consts.THIRD, false);
        radius = countLine(Consts.FIRST, Consts.SECOND, false);
        return (checkRadius <= radius) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
