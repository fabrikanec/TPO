package function.trigonometric;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SecTestPiToHalfPi {
    private static final double DELTA = 1e-5;

	private final double argument;

    private final double accuracy;

    private final double expected;

    public SecTestPiToHalfPi(double argument, double accuracy, double expected) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
    }

    @Parameters
    public static List<Double[]> data() {
        List<Double[]> data = new ArrayList<>();

        for (double acc = 1e-3; acc > 1e-7; acc *= 1e-1) {
            for (double x = PI/2; x < PI; x += PI/4) {
                data.add(new Double[] { x, acc, new Sec(acc, true).calc(x) });
            }
        }
        return data;
    }

    @Test
    public void testSec() {
        double result = new Sec(accuracy).calc(argument);;
        assertEquals(String.format("expected %f = %f +- %f = Sec(%f)\n", expected, result, DELTA, argument),
                expected, result, accuracy);
    }
}
