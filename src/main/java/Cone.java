import consts.Consts;

import java.util.ArrayList;

public class Cone extends Figure {

    public Cone(ArrayList<Point> dots, int points_amount, boolean isTwoCoordinates) {
        super(dots, points_amount, isTwoCoordinates);
    }

    private boolean checkCorner() {
        ArrayList<Integer> h_coord = new ArrayList<>();
        h_coord.add(dots.get(Consts.FIRST).getX() - dots.get(Consts.SECOND).getX());
        h_coord.add(dots.get(Consts.FIRST).getY() - dots.get(Consts.SECOND).getY());
        h_coord.add(dots.get(Consts.FIRST).getZ() - dots.get(Consts.SECOND).getZ());

        ArrayList<Integer> radius_coord = new ArrayList<>();
        radius_coord.add(dots.get(Consts.THIRD).getX() - dots.get(Consts.FIRST).getX());
        radius_coord.add(dots.get(Consts.THIRD).getY() - dots.get(Consts.FIRST).getY());
        radius_coord.add(dots.get(Consts.THIRD).getZ() - dots.get(Consts.FIRST).getZ());


        return  h_coord.get(Consts.FIRST) * radius_coord.get(Consts.FIRST) +
                h_coord.get(Consts.SECOND) * radius_coord.get(Consts.SECOND) +
                h_coord.get(Consts.THIRD) * radius_coord.get(Consts.THIRD) == 0;

    }

    public String getArea() {
        double radius = countLine(Consts.FIRST, Consts.SECOND, false);
        double h = countLine(Consts.SECOND, Consts.THIRD, false);
        return String.format("%.2f", Math.PI * radius * (h + radius));
    }

    public String getPerimeter() {
        return " has no perimeter";
    }

    public boolean isValid() {
        return checkCorner() && super.isValid();
    }

    public boolean isFigure() {
        return false;
    }
}
