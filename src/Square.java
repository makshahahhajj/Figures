import java.util.ArrayList;

public class Square extends Figure {

    private double line = 0;

    public Square(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }

    private double setLine(Point p1, Point p2) {
        if (Points.get(0).len() == 2) {
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        } else {
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2));
        }
    }
    public String getArea() {
        return String.format("%.2f", Math.pow(line, 2));
    }

    public  String getPerimeter() {
        return String.format(" perimeter %.2f", line * 4);
    }

    public  boolean isValid() {
        double firstLine = setLine(Points.get(0),Points.get(1));
        double secondLine = setLine(Points.get(3),Points.get(0));

        line = firstLine;

        for (int i = 1; i < Points.size() - 1; i++) {
            double l = setLine(Points.get(i), Points.get(i + 1));
            if (firstLine != l) {
                return false;
            }
        }

        return (firstLine == secondLine) && super.isValid();
    }
}
