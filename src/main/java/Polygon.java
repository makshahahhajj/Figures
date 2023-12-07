import consts.Consts;

import java.util.ArrayList;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
    }

    public String getPerimeter() {
        double perim = 0;

        if (dots.get(0).len() == 2) {
            for (int i = 0; i < dots.size() - 1; i++) {
                perim += Math.sqrt(Math.pow(dots.get(i).getX() - dots.get(i + 1).getX(), 2) + Math.pow(dots.get(i).getY() - dots.get(i + 1).getY(), 2));
            }
            perim += Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(dots.size() - 1).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(dots.size() - 1).getY(), 2));
        } else {
            for (int i = 0; i < dots.size() - 1; i++) {
                perim += Math.sqrt(Math.pow(dots.get(i).getX() - dots.get(i + 1).getX(), 2) + Math.pow(dots.get(i).getY() - dots.get(i + 1).getY(), 2) + Math.pow(dots.get(i).getZ() - dots.get(i + 1).getZ(), 2));
            }
            perim += Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(dots.size() - 1).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(dots.size() - 1).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(dots.size() - 1).getZ(), 2));

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

                Triangle tr = new Triangle(points, 3, 3, 3);

                area += tr.getAreaDouble();

                points.clear();
            }

            return String.format("%.2f", area);
        }

    }

    public boolean isValid() {
        double endLine;
        if (dots.get(0).len() == Consts.THREE_POINT){
            endLine = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(dots.size() - 1).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(dots.size() - 1).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(dots.size() - 1).getZ(), 2));
        } else {
            endLine = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(dots.size() - 1).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(dots.size() - 1).getY(), 2));
        }

        return !String.format(" perimeter %.2f", 2 * endLine).equals(getPerimeter()) && !(dots.size() < 3) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
