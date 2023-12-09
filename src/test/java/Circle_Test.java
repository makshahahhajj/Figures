import consts.Consts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

public class Circle_Test {
    private Circle circle;

    @Test
    @DisplayName("Circle test passed")
    public void testCircle() {
        ArrayList<Point> points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0"}),
                new Point(new String[]{"1", "0"})
        ));

        circle = new Circle(points, Consts.TWO_POINT, true);
        then(circle.getArea()).isEqualTo("3,14");
        then(circle.getPerimeter()).isEqualTo(" perimeter 6,28");

        points = new ArrayList<>(Arrays.asList(
                new Point(new String[]{"0", "0", "0"}),
                new Point(new String[]{"1", "0", "1"})
        ));

        circle = new Circle(points, Consts.TWO_POINT, true);
        then(circle.getArea()).isEqualTo("6,28");
        then(circle.getPerimeter()).isEqualTo(" perimeter 8,89");


    }
}
