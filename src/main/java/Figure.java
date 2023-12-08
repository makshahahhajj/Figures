import java.util.ArrayList;

public class Figure {
    private int n = 0;
    private int count1 = 0;
    private int count2 = 0;
    protected  ArrayList<Point> dots = new ArrayList<>();

    public Figure(ArrayList<Point> dots, int n, int count1, int count2) {
        this.dots = dots;
        this.n = n;
        this.count1 = count1;
        this.count2 = count2;
    }

    public Figure () {}
    public String getArea() {
        return null;
    }

    public  String getPerimeter() {
        return null;
    }

    public  boolean isValid() {
        for (int i = 0; i < dots.size(); ++i) {
            if (dots.get(i).len() != count1 && dots.get(i).len() != count2) {
                return false;
            }
        }

        for (int i = 0; i < dots.size(); i++) {
            for (int j = 0; j < dots.size(); j++) {
                if (dots.get(i).isEqual(dots.get(j)) && i != j) {
                    return false;
                }
            }
        }

        Point p = dots.get(0);
        for(Point point : dots) {
           if (point.len() != p.len()) {
               return false;
            }
        }

        return dots.size() == n;
    }
    public boolean isFigure() {
        return true;
    }
}
