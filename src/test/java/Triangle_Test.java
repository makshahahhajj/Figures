import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Triangle_Test {
    private Triangle triangle;

    @Test
    @DisplayName("Triangle test passed")
    public void triangle() {
        //Проверка на треугольник и проверка расчетов
        ArrayList<Point > points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2"}),
                new Point(new String[]{"2", "4"}),
                new Point(new String[]{"3", "2"})
        ));
        triangle = new Triangle(points, 3, true);
        then(triangle.isValid()).isTrue();
        then(triangle.getArea()).isEqualTo("2,00");
        then(triangle.getPerimeter()).isEqualTo(" perimeter 6,47");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2", "1"}),
                new Point(new String[]{"2", "4", "1"}),
                new Point(new String[]{"3", "2", "1"})
        ));
        triangle = new Triangle(points, 3, true);
        then(triangle.isValid()).isTrue();
        then(triangle.getArea()).isEqualTo("2,00");
        then(triangle.getPerimeter()).isEqualTo(" perimeter 6,47");

        //Точки лежат на одной линии
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "1"}),
                new Point(new String[]{"2", "2"}),
                new Point(new String[]{"3", "3"})
        ));
        triangle = new Triangle(points, 3, true);
        then(triangle.isValid()).isFalse();

    }
}
