import consts.Consts;

import java.util.ArrayList;

public class Triangle extends Figure{

    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;

    public Triangle(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
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
        return String.format(" perimeter %.2f", line1 + line2 + line3);
    }

    public boolean isValid() {
        boolean isTwoDots = dots.get(0).len() == 2;
        line1 = countLine(Consts.FIRST, Consts.SECOND, isTwoDots);
        line2 = countLine(Consts.SECOND, Consts.THIRD, isTwoDots);
        line3 = countLine(Consts.THIRD, Consts.FIRST, isTwoDots);

        return (line1 < line2 + line3 && line2 < line1 + line3 && line3 < line1 + line2) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }

}
