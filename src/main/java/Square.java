import consts.Consts;

import java.util.ArrayList;

public class Square extends Figure {
    private double line = 0;
    private boolean checkLen = dots.get(0).len() == 2;

    public Square(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
    }

    private boolean checkCorner() {
        if (checkLen) {
            ArrayList<Integer> coord1 = new ArrayList<>();
            coord1.add(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX());
            coord1.add(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY());

            ArrayList<Integer> coord2 = new ArrayList<>();
            coord2.add(dots.get(Consts.THIRD).getX() - dots.get(Consts.SECOND).getX());
            coord2.add(dots.get(Consts.THIRD).getY() - dots.get(Consts.SECOND).getY());

            return (coord1.get(Consts.FIRST) * coord2.get(Consts.FIRST) + coord1.get(Consts.SECOND) *
                    coord2.get(Consts.SECOND)) == 0;
        } else {
            ArrayList<Integer> coord1 = new ArrayList<>();
            coord1.add(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX());
            coord1.add(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY());
            coord1.add(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ());

            ArrayList<Integer> coord2 = new ArrayList<>();
            coord2.add(dots.get(Consts.THIRD).getX() - dots.get(Consts.SECOND).getX());
            coord2.add(dots.get(Consts.THIRD).getY() - dots.get(Consts.SECOND).getY());
            coord2.add(dots.get(Consts.THIRD).getZ() - dots.get(Consts.SECOND).getZ());

            return (coord1.get(Consts.FIRST) * coord2.get(Consts.FIRST) + coord1.get(Consts.SECOND) *
                    coord2.get(Consts.SECOND) + coord1.get(Consts.THIRD) * coord2.get(Consts.THIRD)) == 0;
        }
    }

    public String getArea() {
        return String.format("%.2f", Math.pow(line, 2));
    }

    public  String getPerimeter() {
        return String.format(" perimeter %.2f", line * 4);
    }

    public  boolean isValid() {
        boolean isTwoDots = dots.get(0).len() == 2;
        double firstLine = countLine(Consts.FIRST, Consts.SECOND, isTwoDots);
        double secondLine = countLine(Consts.FOURTH, Consts.FIRST, isTwoDots);

        line = firstLine;

        for (int i = 1; i < dots.size() - 1; i++) {
            double l = countLine(i, i + 1, isTwoDots);
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
