package Cone_Test;

import point.Point;
import consts.Consts;
import figures.Cone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Cone_getPerimeter_Test {
    private Cone conus;

    @Test
    @DisplayName("figures.Cone test passed")
    public void coneTest() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"0", "0", "1"})
        ));

        conus = new Cone(points, Consts.THREE_POINT, true);
        then(conus.getPerimeter()).isEqualTo("The figure has no perimeter");


    }

}
