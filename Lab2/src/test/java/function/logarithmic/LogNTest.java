package function.logarithmic;

import function.AbstractFunction;
import org.junit.Ignore;
import org.junit.Test;
import util.Writer;

import static org.junit.Assert.*;

/**
 * Created by ivan on 16.04.16.
 */
public class LogNTest {
    private AbstractFunction funcFromTable = new LogN(1e-5, true);
    private AbstractFunction func = new LogN(1e-3);
    private double expected, result, arg, logBase = 3;

    private String ERROR_STR = "expected %f == %f +- %f == " + func.getClass().getSimpleName() + "(%f)\n";

    @Test
    public void LogarithmicTestNegInf() {
        arg = Double.NEGATIVE_INFINITY;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestPosInf() {
        arg = Double.POSITIVE_INFINITY;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestNaN() {
        arg = Double.NaN;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestZeroL() {
        arg = -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestZero() {
        arg = 0.0;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestZeroR() {
        arg = 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestOneR() {
        arg = 1-0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestOne() {
        arg = 1;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestOneL() {
        arg = 1+0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestBaseL() {
        arg = logBase-0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestBase() {
        arg = logBase;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Test
    public void LogarithmicTestBaseR() {
        arg = logBase+0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, func.getAccuracy(), arg),
                expected,
                result,
                func.getAccuracy());
    }

    @Ignore
    @Test
    public void generate() {
        Writer writer = new Writer();
        writer.setFunction(new LogN(1e-4, 2));
        writer.toCSVFile(0.0, 5.0, 0.001);
    }
}
