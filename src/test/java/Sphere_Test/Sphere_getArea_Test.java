package Sphere_Test;

import point.Point;
import consts.Consts;
import figures.Sphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Sphere_getArea_Test {
    private Sphere sphere;

    @Test
    @DisplayName("Sphere getArea test passed")
    public void sphereArea() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "1", "1"})
        ));

        sphere = new Sphere(points, Consts.TWO_POINT, true);
        then(sphere.getArea()).isEqualTo("37,70");
    }
}
