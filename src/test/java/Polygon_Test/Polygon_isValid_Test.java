package Polygon_Test;

import point.Point;
import figures.Polygon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Polygon_isValid_Test {
    private Polygon polygon;

    @Test
    @DisplayName("Polygon isValid test passed")
    public void polygonValid() {
        //Валидные координаты
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "2"}),
                new Point(new String[]{"1", "4", "2"}),
                new Point(new String[]{"4", "3", "2"}),
                new Point(new String[]{"4", "2", "2"}),
                new Point(new String[]{"3", "1", "2"})
        ));

        polygon = new Polygon(points, 5, false);
        then(polygon.isValid()).isTrue();

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "4"}),
                new Point(new String[]{"4", "3"}),
                new Point(new String[]{"4", "2"}),
                new Point(new String[]{"3", "1"})
        ));

        polygon = new Polygon(points, 5, false);
        then(polygon.isValid()).isTrue();

        // Точки находятся на одной линии
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "1"}),
                new Point(new String[]{"2", "2"}),
                new Point(new String[]{"3", "3"}),
                new Point(new String[]{"4", "4"})
        ));

        polygon = new Polygon(points, 5, false);
        then(polygon.isValid()).isFalse();

    }
}
