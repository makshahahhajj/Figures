import java.util.ArrayList;

public class Cylinder extends Figure{
    private boolean flag1 = false;

    public Cylinder(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }
    private boolean checkCorner() {
        ArrayList<Integer> coord1 = new ArrayList<>();
        coord1.add(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX());
        coord1.add(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY());
        coord1.add(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ());

        ArrayList<Integer> coord2 = new ArrayList<>();
        coord2.add(Points.get(CONSTS.THIRD).getX() - Points.get(CONSTS.FIRST).getX());
        coord2.add(Points.get(CONSTS.THIRD).getY() - Points.get(CONSTS.FIRST).getY());
        coord2.add(Points.get(CONSTS.THIRD).getZ() - Points.get(CONSTS.FIRST).getZ());

        ArrayList<Integer> coord3 = new ArrayList<>();
        coord3.add(Points.get(CONSTS.THIRD).getX() - Points.get(CONSTS.SECOND).getX());
        coord3.add(Points.get(CONSTS.THIRD).getY() - Points.get(CONSTS.SECOND).getY());
        coord3.add(Points.get(CONSTS.THIRD).getZ() - Points.get(CONSTS.SECOND).getZ());

        if (coord1.get(CONSTS.FIRST) * coord2.get(CONSTS.FIRST) + coord1.get(CONSTS.SECOND) * coord2.get(CONSTS.SECOND) + coord1.get(CONSTS.THIRD) * coord2.get(CONSTS.THIRD) == 0) {
            flag1 = true;
            return true;
        }

        return coord1.get(CONSTS.FIRST) * coord3.get(CONSTS.FIRST) + coord1.get(CONSTS.SECOND) * coord3.get(CONSTS.SECOND) + coord1.get(CONSTS.THIRD) * coord3.get(CONSTS.THIRD) == 0;
    }

    public String getPerimeter() {
        return " has no perimeter";
    }

    public String getArea() {
        double h = 0;
        double radius = 0;

        if (!flag1) {
            h = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY(), 2) + Math.pow(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ(), 2));
            radius = Math.sqrt(Math.pow(Points.get(CONSTS.SECOND).getX() - Points.get(CONSTS.THIRD).getX(), 2) + Math.pow(Points.get(CONSTS.SECOND).getY() - Points.get(CONSTS.THIRD).getY(), 2) + Math.pow(Points.get(CONSTS.SECOND).getZ() - Points.get(CONSTS.THIRD).getZ(), 2));
        } else {
            h = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY(), 2) + Math.pow(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ(), 2));
            radius = Math.sqrt(Math.pow(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.THIRD).getX(), 2) + Math.pow(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.THIRD).getY(), 2) + Math.pow(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.THIRD).getZ(), 2));
        }

        return String.format("%.2f", 2 * Math.PI * radius * (radius + h));
    }

    public boolean isValid() {
        return checkCorner() && super.isValid();
    }
}
