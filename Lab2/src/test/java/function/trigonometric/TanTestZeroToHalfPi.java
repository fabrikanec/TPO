package function.trigonometric;


import function.trigonometric.Tan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TanTestZeroToHalfPi {
    private final double argument;

    private final double accuracy;

    private final double expected;

    public TanTestZeroToHalfPi(double argument, double accuracy, double expected) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
    }

    @Parameters
    public static List<Double[]> data() {
        List<Double[]> data = new ArrayList<>();

        for (double acc = 1e-3; acc > 1e-7; acc *= 1e-1) {
            for (double x = 0; x < PI/2; x += PI/4) {
                data.add(new Double[] { x, acc, new Tan(acc, true).calc(x) });
            }
        }
        return data;
    }

    @Test
    public void testTan() {
        double result = new Tan(accuracy).calc(argument);;
        assertEquals(String.format("expected %f = %f +- %f = Tan(%f)\n", expected, result, accuracy, argument),
                expected, result, accuracy);
    }
}