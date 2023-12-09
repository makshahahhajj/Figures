package figures;

import point.Point;
import consts.Consts;

import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getPerimeter() {
        double perimeter = 0;
        for (int i = 0; i < dots.size() - 1; ++i) {
            perimeter += math.countLine(i, i + 1);
        }

        perimeter += math.countLine(Consts.FIRST, dots.size() - 1);


        return String.format("%.2f", perimeter);
    }
    @Override
    public String getArea() {
        double area = 0;
        Point main = dots.get(0);

        for (int i = 1; i < dots.size() - 1; i++) {
            Triangle tr = new Triangle(new ArrayList<Point>(Arrays.asList(
                    main,
                    dots.get(i),
                    dots.get(i + 1)
            )), Consts.THREE_POINT, true);

            area += tr.getAreaDouble();
        }

        return String.format("%.2f", area);
    }

    public boolean isValid() {
        double endLine = math.countLine(Consts.FIRST, dots.size() - 1);

        return !String.format("%.2f", 2 * endLine).equals(getPerimeter()) && (dots.size() >= 3) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
