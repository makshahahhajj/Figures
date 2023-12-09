import consts.Consts;

import java.util.ArrayList;

public class Rectangle extends Figure{
    private double lineOne = 0;
    private double lineTwo  = 0;

    private boolean checkLen = dots.get(0).len() == 2;
    public Rectangle(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
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

            return (coord1.get(Consts.FIRST) * coord2.get(Consts.FIRST) + coord1.get(Consts.SECOND) * coord2.get(Consts.SECOND)) == 0;
        } else {
            ArrayList<Integer> coord1 = new ArrayList<>();
            coord1.add(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX());
            coord1.add(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY());
            coord1.add(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ());

            ArrayList<Integer> coord2 = new ArrayList<>();
            coord2.add(dots.get(Consts.THIRD).getX() - dots.get(Consts.SECOND).getX());
            coord2.add(dots.get(Consts.THIRD).getY() - dots.get(Consts.SECOND).getY());
            coord2.add(dots.get(Consts.THIRD).getZ() - dots.get(Consts.SECOND).getZ());

            return (coord1.get(Consts.FIRST) * coord2.get(Consts.FIRST) + coord1.get(Consts.SECOND) * coord2.get(Consts.SECOND) + coord1.get(Consts.THIRD) * coord2.get(Consts.THIRD)) == 0;
        }
    }

    public String getArea() {
        return String.format("%.2f", lineOne * lineTwo);
    }

    public  String getPerimeter() {
        return String.format(" perimeter %.2f", 2 * (lineTwo + lineOne));
    }

    public  boolean isValid() {
        boolean isTwoDots = dots.get(Consts.FIRST).len() == 2;

        double line1 = countLine(Consts.FIRST, Consts.SECOND, isTwoDots);
        double line2 = countLine(Consts.SECOND, Consts.THIRD, isTwoDots);
        double line3 = countLine(Consts.THIRD, Consts.FOURTH, isTwoDots);
        double line4 = countLine(Consts.FOURTH, Consts.FIRST, isTwoDots);


        lineOne = line1;
        lineTwo = line2;

        return checkCorner() && !(line1 != line3 || line2 != line4 || line1 == line2) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
