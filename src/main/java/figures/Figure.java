package figures;

import point.Point;
import math.MathOper;

import java.util.ArrayList;

public class Figure {
    private int points_amount = 0;
    protected MathOper math;
    protected  ArrayList<Point> dots = new ArrayList<>();
    private boolean isOnlyThreePoints = false;
    public Figure(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        this.dots = dots;
        this.points_amount = points_amount;
        this.isOnlyThreePoints = isOnlyThreePoints;
        this.math = new MathOper(dots);
    }

    public Figure () {}
    public String getArea() {
        return null;
    }

    public  String getPerimeter() {
        return null;
    }

    public  boolean isValid() {
        for (int i = 0; i < dots.size(); i++) {
            for (int j = 0; j < dots.size(); j++) {
                if (dots.get(i).isEqual(dots.get(j)) && i != j) {
                    return false;
                }
            }
        }

        Point p = dots.get(0);
        for(Point point : dots) {
            int point_len = point.len();
            if (point_len != p.len()) {
               return false;
            }
            if (isOnlyThreePoints && point_len != 3) {
                return false;
            }

        }

        return dots.size() == points_amount;


    }

    public boolean getIsOnlyThreePoint() {
        return isOnlyThreePoints;
    }
    public boolean isFigure() {
        return true;
    }


}
