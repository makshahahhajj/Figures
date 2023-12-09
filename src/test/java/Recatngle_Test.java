import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Recatngle_Test {
    private Rectangle rectangle;

    @Test
    @DisplayName("Rectangle test passed")
    public void rectangleTest() {
        //Проверка на параллельность и что угол между смежными сторонами равен 90 градусов и проверка расчетов
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"2", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"0", "1", "0"})
        ));
        rectangle = new Rectangle(points, 4, true);
        then(rectangle.isValid()).isTrue();
        then(rectangle.getArea()).isEqualTo("2,00");
        then(rectangle.getPerimeter()).isEqualTo(" perimeter 6,00");

        //Проверка на непараллельность
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"0", "1", "0"})
        ));
        rectangle = new Rectangle(points, 4, true);
        then(rectangle.isValid()).isFalse();

        //Проверка на угол не в 90 градусов при условии, что стороны параллельны
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"1", "1", "0"})
        ));
        rectangle = new Rectangle(points, 4, true);
        then(rectangle.isValid()).isFalse();

    }
}
