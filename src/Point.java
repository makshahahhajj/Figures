import java.util.ArrayList;

public class Point {
    private ArrayList<Integer> coords = new ArrayList<>();

    public Point(String[] cords) {
        for (int i = 0; i < cords.length; i++) {
            this.coords.add(Integer.parseInt(cords[i]));
        }
    }

    public int getX() {
        return coords.get(0);
    }

    public int getY() {
        return coords.get(1);
    }

    public int getZ() {
        return coords.get(2);
    }

    public int len() {
        return coords.size();
    }

    public boolean isEqual(Point p) {
        if (coords.size() == 3) {
            return getX() == p.getX() && getY() == p.getY() && getZ() == p.getZ();
        } else if (coords.size() == 2) {
           return getX() == p.getX() && getY() == p.getY();
        }

        return false;
    }

}
