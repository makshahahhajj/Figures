import java.util.ArrayList;

public class Sphere extends Figure{

    public Sphere(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }

    public String getPerimeter() {
        return " has no perimeter";

    }


    public String getArea() {
        double radius = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY(), 2) + Math.pow(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ(), 2));
        return String.format("%.2f", 4 * Math.PI * Math.pow(radius, 2));
    }


    public boolean isValid() {
       return super.isValid();
    }
}
