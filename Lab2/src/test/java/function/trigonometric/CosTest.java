package function.trigonometric;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.NaN;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CosTest {
    private final double argument;

    private final double accuracy;

    private final double expected;

    public CosTest(double argument, double accuracy, double expected) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
    }

    @Parameters
    public static List<Double[]> data() {
        List<Double[]> data = new ArrayList<>();

        data.addAll(Arrays.asList(new Double[][] {
                { NaN, NaN, NaN },
                { NaN, 1e-3, NaN },
                { 1.0, NaN, NaN },
                { Double.POSITIVE_INFINITY, 1e-3, NaN },
                { Double.NEGATIVE_INFINITY, 1e-3, NaN },
        }));

        return data;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCos() {
        System.out.println(accuracy);
        double result = new Cos(accuracy).calc(argument);
        assertEquals(String.format("expected %f = %f +- %f = COS(%f)\n", expected, result, accuracy, argument),
                expected, result, accuracy);
    }
}
