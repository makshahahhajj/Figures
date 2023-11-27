import java.util.ArrayList;

public class Square extends Figure {
    private double line = 0;

    public Square(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
    }

    private double setLine(Point p1, Point p2) {
        if (dots.get(0).len() == 2) {
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
        double firstLine = setLine(dots.get(0), dots.get(1));
        double secondLine = setLine(dots.get(3), dots.get(0));

        line = firstLine;

        for (int i = 1; i < dots.size() - 1; i++) {
            double l = setLine(dots.get(i), dots.get(i + 1));
            if (firstLine != l) {
                return false;
            }
        }

        return (firstLine == secondLine) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
