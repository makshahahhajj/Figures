package math;
import point.Point;
import consts.Consts;

import java.util.ArrayList;


public class MathOper {
    private final ArrayList<Point> dots;
    public MathOper(ArrayList<Point> dots) {
        this.dots = dots;
    }
    // вычисление расстояния между точками
    public double countLine (int first_point, int second_point) {
        double xCord = Math.pow((dots.get(first_point).getX() - dots.get(second_point).getX()), 2);
        double yCord = Math.pow((dots.get(first_point).getY() - dots.get(second_point).getY()), 2);
        double zCord =  Math.pow((dots.get(first_point).getZ() - dots.get(second_point).getZ()), 2);

        return Math.sqrt(xCord + yCord + zCord);
    }
    // Проверка угла на 90 градусов
    public ArrayList<Integer> doLineCords(int first_point, int second_point) {
        ArrayList<Integer> coord = new ArrayList<>();
        coord.add(dots.get(first_point).getX() - dots.get(second_point).getX());
        coord.add(dots.get(first_point).getY() - dots.get(second_point).getY());
        coord.add(dots.get(first_point).getZ() - dots.get(second_point).getZ());

        return coord;
    }

    public boolean countingScalar(ArrayList<Integer> line1, ArrayList<Integer> line2) {
        return  line1.get(Consts.FIRST) * line2.get(Consts.FIRST) +
                line1.get(Consts.SECOND) * line2.get(Consts.SECOND) +
                line1.get(Consts.THIRD) * line2.get(Consts.THIRD) == 0;
    }



}
