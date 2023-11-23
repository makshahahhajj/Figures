import java.util.ArrayList;

public class Triangle extends Figure{

    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;

    public Triangle(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }

    private double setline (Point point1, Point point2) {
         if (point1.len() == 2) {
             return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
         } else {
             return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2) + Math.pow(point1.getZ() - point2.getZ(), 2));
         }

    }

    public String getArea() {
        double per = (line1 + line2 + line3) / 2;
        return String.format("%.2f", Math.sqrt(per * (per - line1) * (per - line2) * (per - line3)));

    }

    public double getAreaDouble() {
        double per = (line1 + line2 + line3) / 2;
        return Math.sqrt(per * (per - line1) * (per - line2) * (per - line3));

    }

    public  String getPerimeter() {
        return String.format(" perimeter %.2f", line1 + line2 + line3);
    }

    public boolean isValid() {
        line1 = setline(Points.get(CONSTS.FIRST), Points.get(CONSTS.SECOND));
        line2 = setline(Points.get(CONSTS.SECOND), Points.get(CONSTS.THIRD));
        line3 = setline(Points.get(CONSTS.THIRD), Points.get(CONSTS.FIRST));

        return !(line1 >= line2 + line3 || line2 >= line1 + line3 || line3 >= line1 + line2) && super.isValid();
    }
}
