package Figure_Test;

import point.Point;
import consts.Consts;
import figures.Figure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Figure_isValid_Test {
    private Figure figure;

    @Test
    @DisplayName("Figure isValid test passed")
    public void figureValid() {
        figure = new Figure();

        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"1", "0", "0"})
        ));

        figure = new Figure(points, Consts.THREE_POINT, true);
        //Совпадение точки, ожидаемый результат false
        then(figure.isValid()).isFalse();

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "0", "0"})
        ));

        //несовпадение количества точек, ожидаемый результат false
        figure = new Figure(points, Consts.FOUR_POINT,  true);
        then(figure.isValid()).isFalse();


        // ввод валидных координат, ожидаемый результат true
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "0"}),
                new Point(new String[]{"2", "0", "0"})
        ));

        figure = new Figure(points, Consts.THREE_POINT, false);
        then(figure.isValid()).isTrue();

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"}),
                new Point(new String[]{"2", "0"})
        ));

        figure = new Figure(points, Consts.THREE_POINT, false);
        then(figure.isValid()).isTrue();

        // проверка на совпаденниие координат в точке
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0", "1"}),
                new Point(new String[]{"2", "0"})
        ));

        figure = new Figure(points, Consts.THREE_POINT, false);
        then(figure.isValid()).isFalse();

    }
}
