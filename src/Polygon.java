import java.util.ArrayList;

public class Polygon extends Figure {

    public Polygon(ArrayList<Point> Points, int n, int count1, int count2) {
        super(Points, n, count1, count2);
    }

    public String getPerimeter() {
        double perim = 0;

        if (Points.get(0).len() == 2) {
            for (int i = 0; i < Points.size() - 1; i++) {
                perim += Math.sqrt(Math.pow(Points.get(i).getX() - Points.get(i + 1).getX(), 2) + Math.pow(Points.get(i).getY() - Points.get(i + 1).getY(), 2));
            }
        } else {
            for (int i = 0; i < Points.size() - 1; i++) {
                perim += Math.sqrt(Math.pow(Points.get(i).getX() - Points.get(i + 1).getX(), 2) + Math.pow(Points.get(i).getY() - Points.get(i + 1).getY(), 2) + Math.pow(Points.get(i).getZ() - Points.get(i + 1).getZ(), 2));
            }
        }

        return String.format(" perimeter %.2f", perim);
    }
    @Override
    public String getArea() {
        double area = 0;
        if (Points.get(0).len() == 2) {

            for (int i = 0; i < Points.size() - 1; i++) {
                area += Points.get(i).getX() * Points.get(i + 1).getY() - Points.get(i + 1).getX() * Points.get(i).getY();
            }

            area += Points.get(Points.size() - 1).getX() * Points.get(0).getY() - Points.get(0).getX() * Points.get(Points.size() - 1).getY();

            return String.format("%.2f", Math.abs(area) / 2);
        } else {
            Point main = Points.get(0);

            ArrayList<Point> points = new ArrayList<>();

            area = 0;

            for (int i = 1; i < Points.size() - 1; i++) {
                points.add(main);
                points.add(Points.get(i));
                points.add(Points.get(i+1));

                Triangle tr = new Triangle(points, 3, 3, 3);

                area += tr.getAreaDouble();

                points.clear();
            }

            return String.format("%.2f", area);
        }

    }

    public boolean isValid() {
        return !(Points.size() < 3) && super.isValid();
    }
}
