import consts.Consts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Cone_Test {
    private Cone conus;

    @Test
    @DisplayName("Cone test passed")
    public void coneTest() {
        // Проверка на перепендикулярность и проверка расчетов
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"0", "0", "1"})
        ));

        conus = new Cone(points, Consts.THREE_POINT, false);
        then(conus.isValid()).isTrue();
        then(conus.getArea()).isEqualTo("7,58");
        then(conus.getPerimeter()).isEqualTo(" has no perimeter");

        //Проверка на неперпенидикулярность
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        conus = new Cone(points, Consts.THREE_POINT, false);

        then(conus.isValid()).isFalse();

    }

}
