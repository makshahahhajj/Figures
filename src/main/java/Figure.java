import consts.Consts;

import java.util.ArrayList;

public class Figure {
    private int points_amount = 0;
    protected  ArrayList<Point> dots = new ArrayList<>();
    protected boolean isTwoCoordinates = false;
    public Figure(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        this.dots = dots;
        this.points_amount = points_amount;
        this.isTwoCoordinates = isTwoCoordinates;
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
           if (point_len != p.len() || point_len > 3 || point_len < 2) {
               return false;
            }
           if (!isTwoCoordinates && point_len < 3) {
               return false;
           }

        }

        return dots.size() == points_amount;


    }
    public boolean isFigure() {
        return true;
    }
    protected double countLine (int first_point, int second_point, boolean isTwoDots) {
        if(isTwoDots) {
            return  Math.sqrt(countPow(first_point, second_point, "x") + countPow(first_point, second_point, "y"));
        } else {
            return Math.sqrt(countPow(first_point, second_point, "x") + countPow(first_point, second_point, "y") + countPow(first_point, second_point, "z"));
        }
    }

    private double countPow(int first_point, int second_point, String os) {
        switch (os) {
            case "x":
                return Math.pow((dots.get(first_point).getX() - dots.get(second_point).getX()), 2);
            case "y":
                return Math.pow((dots.get(first_point).getY() - dots.get(second_point).getY()), 2);
            case "z":
                return Math.pow((dots.get(first_point).getZ() - dots.get(second_point).getZ()), 2);
            default:
                return 0;
        }
    }

}
