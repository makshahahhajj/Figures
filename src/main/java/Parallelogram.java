import consts.Consts;

import java.util.ArrayList;

public class Parallelogram extends Figure {
    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;
    private double line4 = 0;

    public Parallelogram(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
    }

    public String getArea() {
        ArrayList<Point> pointsT = new ArrayList<>(dots);

        pointsT.remove(0);

        Triangle tr = new Triangle(pointsT, Consts.THREE_POINT, true);
        return String.format("%.2f", tr.getAreaDouble() * 2);

    }

    public String getPerimeter () {
        return String.format(" perimeter %.2f", line1 + line2 + line3 + line4);

    }

    public boolean isValid() {
        boolean isTwoDots = dots.get(Consts.FIRST).len() == 2;

        line1 = countLine(Consts.FIRST, Consts.SECOND, isTwoDots);
        line2 = countLine(Consts.SECOND, Consts.THIRD, isTwoDots);
        line3 = countLine(Consts.THIRD, Consts.FOURTH, isTwoDots);
        line4 =  countLine(Consts.FOURTH, Consts.FIRST, isTwoDots);
        System.out.println(line1 + " " + line2 + " " + line3 + " " + line4);

        return (line1 == line3 && line2 == line4 && line1 != line2 && line3 != line4) && super.isValid();

    }

    public boolean isFigure() {
        return false;
    }
}
