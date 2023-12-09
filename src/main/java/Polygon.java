import consts.Consts;

import java.util.ArrayList;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
    }

    public String getPerimeter() {
        double perim = 0;

        if (dots.get(0).len() == 2) {
            for (int i = 0; i < dots.size() - 1; i++) {
                perim += countLine(i, i + 1, true);
            }
            perim += countLine(Consts.FIRST, dots.size() - 1, true);
        } else {
            for (int i = 0; i < dots.size() - 1; i++) {
                perim += countLine(i, i + 1, false);
            }

            perim += countLine(Consts.FIRST, dots.size() - 1, false);
        }

        return String.format(" perimeter %.2f", perim);
    }
    @Override
    public String getArea() {
        double area = 0;
        if (dots.get(0).len() == 2) {

            for (int i = 0; i < dots.size() - 1; i++) {
                area += dots.get(i).getX() * dots.get(i + 1).getY() - dots.get(i + 1).getX() * dots.get(i).getY();
            }

            area += dots.get(dots.size() - 1).getX() * dots.get(0).getY() - dots.get(0).getX() * dots.get(dots.size() - 1).getY();

            return String.format("%.2f", Math.abs(area) / 2);
        } else {
            Point main = dots.get(0);

            ArrayList<Point> points = new ArrayList<>();

            area = 0;

            for (int i = 1; i < dots.size() - 1; i++) {
                points.add(main);
                points.add(dots.get(i));
                points.add(dots.get(i+1));

                Triangle tr = new Triangle(points, Consts.THREE_POINT, true);

                area += tr.getAreaDouble();

                points.clear();
            }

            return String.format("%.2f", area);
        }

    }

    public boolean isValid() {
        double endLine;
        if (dots.get(0).len() == Consts.THREE_POINT){
            endLine = countLine(Consts.FIRST, dots.size() - 1, false);
        } else {
            endLine = countLine(Consts.FIRST, dots.size() - 1, true);
        }

        return !String.format(" perimeter %.2f", 2 * endLine).equals(getPerimeter()) && (dots.size() >= 3) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
