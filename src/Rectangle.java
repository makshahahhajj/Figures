import java.util.ArrayList;

public class Rectangle extends Figure{
    private double lineOne = 0;
    private double lineTwo  = 0;

    private boolean checkLen = Points.get(0).len() == 2;
    public Rectangle(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }

    private boolean checkCorner() {
        if (checkLen) {
            ArrayList<Integer> coord1 = new ArrayList<>();
            coord1.add(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX());
            coord1.add(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY());

            ArrayList<Integer> coord2 = new ArrayList<>();
            coord2.add(Points.get(CONSTS.THIRD).getX() - Points.get(CONSTS.SECOND).getX());
            coord2.add(Points.get(CONSTS.THIRD).getY() - Points.get(CONSTS.SECOND).getY());

            return (coord1.get(CONSTS.FIRST) * coord2.get(CONSTS.FIRST) + coord1.get(CONSTS.SECOND) * coord2.get(CONSTS.SECOND)) == 0;
        } else {
            ArrayList<Integer> coord1 = new ArrayList<>();
            coord1.add(Points.get(CONSTS.FIRST).getX() - Points.get(CONSTS.SECOND).getX());
            coord1.add(Points.get(CONSTS.FIRST).getY() - Points.get(CONSTS.SECOND).getY());
            coord1.add(Points.get(CONSTS.FIRST).getZ() - Points.get(CONSTS.SECOND).getZ());

            ArrayList<Integer> coord2 = new ArrayList<>();
            coord2.add(Points.get(CONSTS.THIRD).getX() - Points.get(CONSTS.SECOND).getX());
            coord2.add(Points.get(CONSTS.THIRD).getY() - Points.get(CONSTS.SECOND).getY());
            coord2.add(Points.get(CONSTS.THIRD).getZ() - Points.get(CONSTS.SECOND).getZ());

            return (coord1.get(CONSTS.FIRST) * coord2.get(CONSTS.FIRST) + coord1.get(CONSTS.SECOND) * coord2.get(CONSTS.SECOND) + coord1.get(CONSTS.THIRD) * coord2.get(CONSTS.THIRD)) == 0;
        }
    }
    private double setLine(Point p1, Point p2) {
        if (checkLen) {
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
        } else {
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2));
        }
    }

    public String getArea() {
        return String.format("%.2f", lineOne * lineTwo);
    }

    public  String getPerimeter() {
        return String.format(" perimeter %.2f", 2 * (lineTwo + lineOne));
    }

    public  boolean isValid() {
        double line1 = setLine(Points.get(CONSTS.FIRST), Points.get(CONSTS.SECOND));
        double line2 = setLine(Points.get(CONSTS.SECOND), Points.get(CONSTS.THIRD));
        double line3 = setLine(Points.get(CONSTS.THIRD), Points.get(CONSTS.FOURTH));
        double line4 = setLine(Points.get(CONSTS.FOURTH), Points.get(CONSTS.FIRST));


        lineOne = line1;
        lineTwo = line2;

        return checkCorner() && !(line1 != line3 || line2 != line4 || line1 == line2) && super.isValid();
    }
}
