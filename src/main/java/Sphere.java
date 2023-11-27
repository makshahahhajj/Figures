import java.util.ArrayList;

public class Sphere extends Figure{

    public Sphere(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
    }

    public String getPerimeter() {
        return " has no perimeter";

    }

    public String getArea() {
        double radius = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ(), 2));
        return String.format("%.2f", 4 * Math.PI * Math.pow(radius, 2));
    }

    public boolean isValid() {
       return super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
