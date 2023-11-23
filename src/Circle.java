import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Circle extends Figure {
    private double radius = 0;

    public Circle(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
        setRadius();
    }
    private void setRadius() {
        if (Points.get(0).len() == 3) {
            radius = Math.sqrt(Math.pow((Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX()), 2) + Math.pow((Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY()), 2) + Math.pow((Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ()), 2));
        } else {
            radius = Math.sqrt(Math.pow((Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX()), 2) + Math.pow((Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY()), 2));

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
        return !(Points.get(0).equals(Points.get(1))) && super.isValid();
    }

}
