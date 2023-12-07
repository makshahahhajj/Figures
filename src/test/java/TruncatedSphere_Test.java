import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphere_Test {
    private TruncatedSphere sphere;

    @Test
    @DisplayName("TrSphere test passed")
    public void TruncatedSpehreTest() {
        //Проверка расчетов и валидных кординат
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "4"}),
                new Point(new String[]{"1", "0", "2"})
        ));
        sphere = new TruncatedSphere(points, 3, 3, 3);
        then(sphere.isValid()).isTrue();
        then(sphere.getArea()).isEqualTo("188,50");
        then(sphere.getPerimeter()).isEqualTo(" has no perimeter");

        //Координата точки окружности сечения вне окружности
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"0", "0", "4"}),
                new Point(new String[]{"4", "0", "2"})
        ));
        sphere = new TruncatedSphere(points, 3, 3, 3);
        then(sphere.isValid()).isFalse();
    }
}
