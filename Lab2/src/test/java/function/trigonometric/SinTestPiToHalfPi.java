package function.trigonometric;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.List;

import static function.AbstractFunction.DELTA;
import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SinTestPiToHalfPi {


	private final double argument;

    private final double accuracy;

    private final double expected;

    public SinTestPiToHalfPi(double argument, double accuracy, double expected) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
    }

    @Parameters
    public static List<Double[]> data() {
        List<Double[]> data = new ArrayList<>();

        for (double acc = 1e-5;acc > 1e-7; acc *= 1e-1) {
            for (double x = PI/2; x < PI; x += PI/4) {
                data.add(new Double[] { x, acc, new SinStub(acc).calc(x) });
            }
        }
        return data;
    }

    @Test
    public void testSin() {
        double result = new Sin(accuracy).calc(argument);;
        assertEquals(String.format("expected %f = %f +- %f = Sin(%f)\n", expected, result, DELTA, argument),
                expected, result, DELTA);
    }
}
