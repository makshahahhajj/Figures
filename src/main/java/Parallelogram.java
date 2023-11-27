import java.util.ArrayList;

public class Parallelogram extends Figure {
    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;
    private double line4 = 0;

    public Parallelogram(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
    }

    public String getArea() {
        ArrayList<Point> pointsT = new ArrayList<>(dots);

        pointsT.remove(0);

        Triangle tr = new Triangle(pointsT, 3, 2, 3);

        return String.format("%.2f", tr.getAreaDouble() * 2);

    }

    public String getPerimeter () {
        return String.format(" perimeter %.2f", line1 + line2 + line3 + line4);

    }

    public boolean isValid() {
        Point point1 = dots.get(Consts.FIRST);
        Point point2 = dots.get(Consts.SECOND);
        Point point3 = dots.get(Consts.THIRD);
        Point point4 = dots.get(Consts.FOURTH);

        line1 = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
        line2 = Math.sqrt(Math.pow(point2.getX() - point3.getX(), 2) + Math.pow(point2.getY() - point3.getY(), 2));
        line3 = Math.sqrt(Math.pow(point3.getX() - point4.getX(), 2) + Math.pow(point3.getY() - point4.getY(), 2));
        line4 =  Math.sqrt(Math.pow(point4.getX() - point1.getX(), 2) + Math.pow(point4.getY() - point1.getY(), 2));

        return !(line1 != line3 || line2 != line4 || line1 == line2) && super.isValid();

    }

    public boolean isFigure() {
        return false;
    }
}
