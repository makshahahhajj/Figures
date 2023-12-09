package point;

public class Point {

    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int amount = 0;

    public Point(String[] cords) {
        this.amount = cords.length;

        x = Integer.parseInt(cords[0]);
        y = Integer.parseInt(cords[1]);

        if (amount == 3) {
            z = Integer.parseInt(cords[2]);
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int len() {
        return amount;
    }

    public boolean isEqual(Point p) {
        return getX() == p.getX() && getY() == p.getY() && getZ() == p.getZ();
    }
}
