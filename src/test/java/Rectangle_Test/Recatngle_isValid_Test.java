package Rectangle_Test;

import point.Point;
import consts.Consts;
import figures.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Recatngle_isValid_Test {
    private Rectangle rectangle;

    @Test
    @DisplayName("Rectangle isValid test passed")
    public void rectangleValid() {
        //Проверка на параллельность и что угол между смежными сторонами равен 90 градусов
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"2", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"0", "1", "0"})
        ));
        rectangle = new Rectangle(points, Consts.FOUR_POINT, false);
        then(rectangle.isValid()).isTrue();

        //Проверка на непараллельность
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"0", "1", "0"})
        ));
        rectangle = new Rectangle(points, Consts.FOUR_POINT, false);
        then(rectangle.isValid()).isFalse();

        //Проверка на угол не в 90 градусов при условии, что стороны параллельны
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "1", "0"}),
                new Point(new String[]{"1", "1", "0"})
        ));
        rectangle = new Rectangle(points, Consts.FOUR_POINT, false);
        then(rectangle.isValid()).isFalse();

    }
}
