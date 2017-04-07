package function.trigonometric;


import function.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.List;

import static function.AbstractFunction.DELTA;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CosTestZero {


	private final double argument;

    private final double accuracy;

    private final double expected;

    public CosTestZero(double argument, double accuracy, double expected) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
    }

    @Parameters
    public static List<Double[]> data() {
        List<Double[]> data = new ArrayList<>();

        for (double acc = 1e-5;acc > 1e-7; acc *= 1e-1) {
            for (double x = -0.001; x < 0.001; x += 0.001) {
                data.add(new Double[] { x, acc, new Cos(acc, Level.One).calc(x) });
            }
        }
        return data;
    }

    @Test
    public void testCos() {
        double result = new Cos(accuracy, Level.Two).calc(argument);;
        assertEquals(String.format("expected %f = %f +- %f = COS(%f)\n", expected, result, DELTA, argument),
                expected, result, DELTA);
    }
}
