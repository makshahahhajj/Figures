import java.util.ArrayList;

public class TruccatedSphere extends Figure{
    private double radius = 0;
    public TruccatedSphere(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
    }

    public String getArea() {
        double truncRadius = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.THIRD).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.FIRST).getY(), 2) + Math.pow(dots.get(Consts.THIRD).getZ() - dots.get(Consts.THIRD).getZ(), 2));
        double h = radius - Math.sqrt(Math.pow(radius, 2) - Math.pow(truncRadius, 2));
        double truncArea = 2 * Math.PI * radius * h;
        double area = 4 * Math.PI * Math.pow(radius, 2) - truncArea + Math.PI * Math.pow(truncRadius, 2);

        return String.format("%.2f", area);
    }

    public String getPerimeter() {
        return " has no perimeter";
    }

    public boolean isValid() {
        double checkRadius = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.THIRD).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.THIRD).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(Consts.THIRD).getZ(), 2));
        radius = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ(), 2));

        return (checkRadius == radius) && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
