import consts.Consts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;


public class Cylinder_Test {
    private Cylinder cylinder;

    @Test
    @DisplayName("Cylinder test passed")
    public void cylinderTest() {
        // Проверка на перпендикулрность и проверка расчетов
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "0"})
        ));
        cylinder = new Cylinder(points, Consts.THREE_POINT, false);
        then(cylinder.isValid()).isTrue();
        then(cylinder.getArea()).isEqualTo("12,57");
        then(cylinder.getPerimeter()).isEqualTo(" has no perimeter");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        cylinder = new Cylinder(points, Consts.THREE_POINT, false);
        then(cylinder.isValid()).isTrue();
        then(cylinder.getArea()).isEqualTo("12,57");
        then(cylinder.getPerimeter()).isEqualTo(" has no perimeter");

        //Проверка на неперпендикулярность образующей к основаниям
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"2", "0", "1"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        cylinder = new Cylinder(points, Consts.THREE_POINT, false);
        then(cylinder.isValid()).isFalse();



    }
}
