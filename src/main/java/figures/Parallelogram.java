package figures;

import jdk.jfr.FlightRecorder;
import point.Point;
import consts.Consts;

import java.util.ArrayList;

public class Parallelogram extends Figure {
    private double line1 = 0;
    private double line2 = 0;
    private double line3 = 0;
    private double line4 = 0;

    public Parallelogram(ArrayList<Point> dots, int points_amount, boolean isOnlyThreePoints) {
        super(dots, points_amount, isOnlyThreePoints);
    }

    public String getArea() {
        ArrayList<Point> pointsT = new ArrayList<>(dots);

        pointsT.remove(0);

        Triangle tr = new Triangle(pointsT, Consts.THREE_POINT, false);
        return String.format("%.2f", tr.getAreaDouble() * 2);

    }

    public String getPerimeter () {
        setLines();
        return String.format("%.2f", line1 + line2 + line3 + line4);

    }

    private void setLines() {
        if (line1 + line2 + line3 + line4 == 0) {
            this.line1 = math.countLine(Consts.FIRST, Consts.SECOND);
            this.line2 = math.countLine(Consts.SECOND, Consts.THIRD);
            this.line3 = math.countLine(Consts.THIRD, Consts.FOURTH);
            this.line4 = math.countLine(Consts.FOURTH, Consts.FIRST);
        }
    }

    public boolean isValid() {
        if (super.isValid()) {
            setLines();
            return line1 == line3 && line2 == line4 && line1 != line2 && line3 != line4;
        }

        return false;
    }

    public boolean isFigure() {
        return false;
    }
}
