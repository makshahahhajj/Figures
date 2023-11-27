import java.util.ArrayList;

public class Triangle extends Figure{

    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;

    public Triangle(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
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
        line1 = setline(dots.get(Consts.FIRST), dots.get(Consts.SECOND));
        line2 = setline(dots.get(Consts.SECOND), dots.get(Consts.THIRD));
        line3 = setline(dots.get(Consts.THIRD), dots.get(Consts.FIRST));

        return !(line1 >= line2 + line3 || line2 >= line1 + line3 || line3 >= line1 + line2) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }

}
