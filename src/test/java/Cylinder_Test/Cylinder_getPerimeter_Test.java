package Cylinder_Test;

import point.Point;
import consts.Consts;
import figures.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;


public class Cylinder_getPerimeter_Test {
    private Cylinder cylinder;

    @Test
    @DisplayName("Cylinder getPerimeter test passed")
    public void cylinderPerimeter() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "0"})
        ));
        cylinder = new Cylinder(points, Consts.THREE_POINT, true);
        then(cylinder.getPerimeter()).isEqualTo("The figure has no perimeter");

    }
}
