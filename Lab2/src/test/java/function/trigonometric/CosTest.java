package function.trigonometric;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
    private static final double DELTA = 1e-5;

	private final double argument;

    private final double accuracy;

    private final double expected;

    private Class<? extends Throwable> errorClass;

    public CosTest(double argument, double accuracy, double expected, Class<? extends Throwable> errorClass) {
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
    public void testCos() {
        if (errorClass != null) {
            exception.expect(errorClass);
        }
        double result = new Cos(accuracy).calc(argument);
        assertEquals(String.format("expected %f = %f +- %f = COS(%f)\n", expected, result, DELTA, argument),
                expected, result, accuracy);
    }
}
