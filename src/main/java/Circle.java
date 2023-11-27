import java.util.ArrayList;

public class Circle extends Figure {
    private double radius = 0;

    public Circle(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
        setRadius();
    }
    private void setRadius() {
        if (dots.get(0).len() == 3) {
            radius = Math.sqrt(Math.pow((dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX()), 2) + Math.pow((dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY()), 2) + Math.pow((dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ()), 2));
        } else {
            radius = Math.sqrt(Math.pow((dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX()), 2) + Math.pow((dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY()), 2));

        }
    }

    @Override
    public String getArea() {
        double area = Math.PI * Math.pow(radius, 2);
        return String.format("%.2f", area);
    }

    @Override
    public String getPerimeter() {
        double per = 2 * Math.PI * radius;
        return String.format(" perimeter %.2f", per);
    }

    @Override
    public boolean isValid() {
        return !(dots.get(0).equals(dots.get(1))) && super.isValid();
    }

    @Override
    public boolean isFigure() {
        return false;
    }
}
