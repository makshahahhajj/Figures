import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Sphere_Test {
    private Sphere sphere;

    @Test
    @DisplayName("Sphere test passed")
    public void sphereTest() {
       // Проверка расчетов
       ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "1", "1"})
        ));

        sphere = new Sphere(points, 2, false);
        then(sphere.isValid()).isTrue();
        then(sphere.getArea()).isEqualTo("37,70");
        then(sphere.getPerimeter()).isEqualTo(" has no perimeter");
    }
}
