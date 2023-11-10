import java.util.ArrayList;

public class Parallelogram extends Figure {
    private static double line1 = 0;
    private static double line2 = 0;
    private static double line3 = 0;
    private static double line4 = 0;

    public Parallelogram(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count1);
    }

    public String getArea() {
        ArrayList<Point> pointsT = Points;

        pointsT.remove(0);

        Triangle tr = new Triangle(pointsT, 3, 2, 3);

        return String.format("%.2f", tr.getAreaDouble() * 2);

    }

    public String getPerimeter () {
        return String.format(" perimeter %.2f", line1 + line2 + line3 + line4);

    }

    public boolean isValid() {
        Point point1 = Points.get(CONSTS.FIRST);
        Point point2 = Points.get(CONSTS.SECOND);
        Point point3 = Points.get(CONSTS.THIRD);
        Point point4 = Points.get(CONSTS.FOURTH);

        line1 = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
        line2 = Math.sqrt(Math.pow(point2.getX() - point3.getX(), 2) + Math.pow(point2.getY() - point3.getY(), 2));
        line3 = Math.sqrt(Math.pow(point3.getX() - point4.getX(), 2) + Math.pow(point3.getY() - point4.getY(), 2));
        line4 =  Math.sqrt(Math.pow(point4.getX() - point1.getX(), 2) + Math.pow(point4.getY() - point1.getY(), 2));

        return !(line1 != line3 || line2 != line4 || line1 == line2) && super.isValid();

    }
}
