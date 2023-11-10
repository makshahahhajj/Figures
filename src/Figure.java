import java.util.ArrayList;

public class Figure {
    protected int n = 0;
    protected int count1 = 0;
    protected int count2 = 0;
    protected  ArrayList<Point> Points = new ArrayList<>();

    public Figure(ArrayList<Point> Points, int n, int count1, int count2) {
        this.Points = Points;
        this.n = n;
        this.count1 = count1;
        this.count2 = count2;
    }
    public String getArea() {
        return null;
    }

    public  String getPerimeter() {
        return null;
    }

    public  boolean isValid() {

        for (int i = 0; i < Points.size(); ++i) {
            int len = Points.get(0).len();
            if (Points.get(i).len() != count1 && Points.get(i).len() != count2 && len != Points.get(i).len()) {
                return false;
            }
        }

        for (int i = 0; i < Points.size(); i++) {
            for (int j = 0; j < Points.size(); j++) {
                if (Points.get(i).isEqual(Points.get(j)) && i != j) {
                    return false;
                }
            }
        }

        return Points.size() == n;
    }
}
