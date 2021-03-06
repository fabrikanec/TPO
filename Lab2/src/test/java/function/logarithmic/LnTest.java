package function.logarithmic;

import function.AbstractFunction;
import function.Level;
import org.junit.Ignore;
import org.junit.Test;
import util.Writer;

import static function.AbstractFunction.DELTA;
import static org.junit.Assert.*;

/**
 * Created by cezar on 16.04.16.
 */
public class LnTest {
    private AbstractFunction funcFromTable = new Ln(1e-10, Level.One);
    private AbstractFunction func = new Ln(1e-10, Level.Two);
    private double expected;
    private double result;
    private double arg;
    private final double logBase = Math.E;
    private String ERROR_STR = "expected %f == %f +- %f == " + func.getClass().getSimpleName() + "(%f)\n";

    @Test
    public void logarithmicTestNegInf() {
        arg = Double.NEGATIVE_INFINITY;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestPosInf() {
        arg = Double.POSITIVE_INFINITY;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestNaN() {
        arg = Double.NaN;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestZeroL() {
        arg = -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestZero() {
        arg = 0.0;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestZeroG() {
        arg = 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestOneL() {
        arg = 1 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestOne() {
        arg = 1;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestOneG() {
        arg = 1 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestBaseL() {
        arg = logBase - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestBase() {
        arg = logBase;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicTestBaseG() {
        arg = logBase + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Ignore
    @Test(timeout = 10000)
    public void generate() {
        Writer writer = new Writer();
        writer.setFunction(new Ln(1e-3, Level.Two));
        writer.toCSVFile(0.0, 5.0, 0.001);
    }
}


