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
public class CscTestPi {
    private final double argument;

    private final double accuracy;

    private final double expected;

    public CscTestPi(double argument, double accuracy, double expected) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
    }

    @Parameters
    public static List<Double[]> data() {
        List<Double[]> data = new ArrayList<>();

        for (double acc = 1e-3; acc > 1e-7; acc *= 1e-1) {
            for (double x = PI-0.001; x < PI+0.001; x += 0.001) {
                data.add(new Double[] { x, acc, new Csc(acc, true).calc(x) });
            }
        }
        return data;
    }

    @Test
    public void testCsc() {
        double result = new Csc(accuracy).calc(argument);;
        assertEquals(String.format("expected %f = %f +- %f = Csc(%f)\n", expected, result, accuracy, argument),
                expected, result, accuracy);
    }
}
