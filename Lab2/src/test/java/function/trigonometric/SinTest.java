package function.trigonometric;


import function.Level;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static function.AbstractFunction.DELTA;
import static java.lang.Double.NaN;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SinTest {


	private final double argument;

    private final double accuracy;

    private final double expected;

    private Class<? extends Throwable> errorClass;

    public SinTest(double argument, double accuracy, double expected, Class<? extends Throwable> errorClass) {
        this.argument = argument;
        this.accuracy = accuracy;
        this.expected = expected;
        this.errorClass = errorClass;
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();

        data.addAll(Arrays.asList(new Object[][] {
                { NaN, NaN, NaN, IllegalArgumentException.class },
                { NaN, 1e-3, NaN, null },
                { 1.0, NaN, NaN, IllegalArgumentException.class },
                { Double.POSITIVE_INFINITY, 1e-3, NaN, null },
                { Double.NEGATIVE_INFINITY, 1e-3, NaN, null },
        }));

        return data;
    }

    @Test
    public void testSin() {
        if (errorClass != null) {
            exception.expect(errorClass);
        }
        double result = new Sin(accuracy, Level.Two).calc(argument);
        assertEquals(String.format("expected %f = %f +- %f = Sin(%f)\n", expected, result, DELTA, argument),
                expected, result, DELTA);
    }
}
