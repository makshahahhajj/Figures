import java.util.ArrayList;

public class Truncated_sphere extends Figure{
    private static double truncRadius = 0;
    private static double radius = 0;

    public Truncated_sphere(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }


    public String getArea() {
        truncRadius = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.THIRD).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.FIRST).getY(), 2) + Math.pow(Points.get(CONSTS.THIRD).getZ() - Points.get(CONSTS.THIRD).getZ(), 2));
        double h = radius - Math.sqrt(Math.pow(radius, 2) - Math.pow(truncRadius, 2));
        double truncArea = 2 * Math.PI * radius * h;
        double area = 4 * Math.PI * Math.pow(radius, 2) - truncArea + Math.PI * Math.pow(truncRadius, 2);

        return String.format("%.2f", area);
    }


    public String getPerimeter() {
        return " has no perimeter";
    }


    public boolean isValid() {
        double checkRadius = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.THIRD).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.THIRD).getY(), 2) + Math.pow(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.THIRD).getZ(), 2));
        radius = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY(), 2) + Math.pow(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ(), 2));

        return (checkRadius == radius) && super.isValid();
    }
}
