import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Square_Test {
    private Square square;

    @Test
    @DisplayName("Square test passed")
    public void squareTest() {
        //Проверка на квадрат(все стороны равны) и проверка расчетов
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "1"}),
                new Point(new String[]{"1", "0", "1"}),
                new Point(new String[]{"1", "1", "1"}),
                new Point(new String[]{"0", "1", "1"})
        ));
        square = new Square(points, 4, 2, 3);
        then(square.isValid()).isTrue();
        then(square.getArea()).isEqualTo("1,00");
        then(square.getPerimeter()).isEqualTo(" perimeter 4,00");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"}),
                new Point(new String[]{"1", "1"}),
                new Point(new String[]{"0", "1"})
        ));
        square = new Square(points, 4, 2, 3);
        then(square.isValid()).isTrue();
        then(square.getArea()).isEqualTo("1,00");
        then(square.getPerimeter()).isEqualTo(" perimeter 4,00");

        //Стороны равны, но угол не в 90 градусов(ромб)
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"1", "2"}),
                new Point(new String[]{"2", "4"}),
                new Point(new String[]{"3", "2"}),
                new Point(new String[]{"2", "0"})
        ));
        square = new Square(points, 4, 2, 3);
        then(square.isValid()).isFalse();

        //Стороны неравны, но угол в 90 градусов(прямоугольник)
        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"0", "1"}),
                new Point(new String[]{"1", "2"}),
                new Point(new String[]{"0", "2"})
        ));
        square = new Square(points, 4, 2, 3);
        then(square.isValid()).isFalse();

    }
}
