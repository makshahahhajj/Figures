import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Parallelogram_Test {
    private Parallelogram parallelogram;

    @Test
    @DisplayName("Parallelogram test passed")
    public void parallelogramTest() {
        // Проверка на параллельность и проверка расчето
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"1", "1", "0"})
        ));
        parallelogram = new Parallelogram(points, 4, 2, 3);
        then(parallelogram.isValid()).isTrue();
        then(parallelogram.getArea()).isEqualTo("1,00");
        then(parallelogram.getPerimeter()).isEqualTo(" perimeter 4,83");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"}),
                new Point(new String[]{"2", "1"}),
                new Point(new String[]{"1", "1"})
        ));
        parallelogram = new Parallelogram(points, 4, 2, 3);
        then(parallelogram.isValid()).isTrue();
        then(parallelogram.getArea()).isEqualTo("1,00");
        then(parallelogram.getPerimeter()).isEqualTo(" perimeter 4,83");

        //Проверка на непараллельность
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"3", "1", "0"}),
                new Point(new String[]{"1", "1", "0"})
        ));
        parallelogram = new Parallelogram(points, 4, 2, 3);
        then(parallelogram.isValid()).isFalse();
        
    }
}
