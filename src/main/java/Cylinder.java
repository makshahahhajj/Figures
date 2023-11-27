import java.util.ArrayList;

public class Cylinder extends Figure{
    private boolean flag1 = false;

    public Cylinder(ArrayList<Point> dots, int n, int count1, int count2) {
        super(dots, n, count1, count2);
    }
    private boolean checkCorner() {
        ArrayList<Integer> coord1 = new ArrayList<>();
        coord1.add(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX());
        coord1.add(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY());
        coord1.add(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ());

        ArrayList<Integer> coord2 = new ArrayList<>();
        coord2.add(dots.get(Consts.THIRD).getX() - dots.get(Consts.FIRST).getX());
        coord2.add(dots.get(Consts.THIRD).getY() - dots.get(Consts.FIRST).getY());
        coord2.add(dots.get(Consts.THIRD).getZ() - dots.get(Consts.FIRST).getZ());

        ArrayList<Integer> coord3 = new ArrayList<>();
        coord3.add(dots.get(Consts.THIRD).getX() - dots.get(Consts.SECOND).getX());
        coord3.add(dots.get(Consts.THIRD).getY() - dots.get(Consts.SECOND).getY());
        coord3.add(dots.get(Consts.THIRD).getZ() - dots.get(Consts.SECOND).getZ());

        if (coord1.get(Consts.FIRST) * coord2.get(Consts.FIRST) + coord1.get(Consts.SECOND) * coord2.get(Consts.SECOND) + coord1.get(Consts.THIRD) * coord2.get(Consts.THIRD) == 0) {
            flag1 = true;
            return true;
        }

        return coord1.get(Consts.FIRST) * coord3.get(Consts.FIRST) + coord1.get(Consts.SECOND) * coord3.get(Consts.SECOND) + coord1.get(Consts.THIRD) * coord3.get(Consts.THIRD) == 0;
    }

    public String getPerimeter() {
        return " has no perimeter";
    }

    public String getArea() {
        double h = 0;
        double radius = 0;

        if (!flag1) {
            h = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ(), 2));
            radius = Math.sqrt(Math.pow(dots.get(Consts.SECOND).getX() - dots.get(Consts.THIRD).getX(), 2) + Math.pow(dots.get(Consts.SECOND).getY() - dots.get(Consts.THIRD).getY(), 2) + Math.pow(dots.get(Consts.SECOND).getZ() - dots.get(Consts.THIRD).getZ(), 2));
        } else {
            h = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ(), 2));
            radius = Math.sqrt(Math.pow(dots.get(Consts.FIRST).getX() - dots.get(Consts.THIRD).getX(), 2) + Math.pow(dots.get(Consts.FIRST).getY() - dots.get(Consts.THIRD).getY(), 2) + Math.pow(dots.get(Consts.FIRST).getZ() - dots.get(Consts.THIRD).getZ(), 2));
        }

        return String.format("%.2f", 2 * Math.PI * radius * (radius + h));
    }

    public boolean isValid() {
        return checkCorner() && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }

}
