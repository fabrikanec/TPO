package system;

import function.AbstractFunction;
import function.Level;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cezar on 4/7/17.
 */
public class TrigonometricTest {
    private AbstractFunction funcFromTable = new Trigonometric(1e-12, Level.One);
    private AbstractFunction func = new Trigonometric(1e-20, Level.Two);
    private double expected, result, arg;
    private static final double DELTA = 1e-3;

    private String ERROR_STR = "expected %f == %f +- %f == " + func.getClass().getSimpleName() + "(%f)\n";


    @Test
    public void trigonometricZeroTest() {
        arg = 0d;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricZeroTestL() {
        arg = -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricZeroTestG() {
        arg = 0.01;
        expected = funcFromTable.calc(arg) /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        result = func.calc(arg)                  /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }
    @Test
    public void trigonometricHalfHalfPiTest() {
        arg = Math.PI / 4;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfHalfPiTestL() {
        arg = Math.PI / 4 -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfHalfPiTestG() {
        arg = Math.PI / 4 + 0.01;
        expected = funcFromTable.calc(arg) /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        result = func.calc(arg)                  /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricPiTest() {
        arg = Math.PI * 2;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricPiTestL() {
        arg = Math.PI * 2 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricPiTestG() {
        arg = Math.PI * 2 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricFstTest() {
        arg = 2.392;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricFstTestL() {
        arg = 2.392 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricFstTestG() {
        arg = 2.392 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfFstTest() {
        arg = 2.392 / 2;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfFstTestL() {
        arg = 2.392 / 2 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfFstTestG() {
        arg = 2.392 / 2 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricPITest() {
        arg = Math.PI;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricPITestL() {
        arg = Math.PI - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricPITestG() {
        arg = Math.PI + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfPITest() {
        arg = Math.PI / 1.75;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfPITestL() {
        arg = Math.PI / 1.75 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfPITestG() {
        arg = Math.PI / 1.75 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricSndTest() {
        arg = 3.891;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricSndTestL() {
        arg = 3.891 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricSndTestG() {
        arg = 3.891 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfSndTest() {
        arg = 3.891 / 2;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfSndTestL() {
        arg = 3.891 / 2 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfSndTestG() {
        arg = 3.891 / 2 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfThreePITest() {
        arg = 3 * Math.PI / 2;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfThreePITestL() {
        arg = 3 * Math.PI / 2 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfThreePITestG() {
        arg = 3 * Math.PI / 2 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfHalfThreePITest() {
        arg = 3 * Math.PI / 4;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfHalfThreePITestL() {
        arg = 3 * Math.PI / 4 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricHalfHalfThreePITestG() {
        arg = 3 * Math.PI / 4 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricAlmostHalfPITest() {
        arg = 2 * Math.PI / 1.75;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricAlmostHalfPITestL() {
        arg = 2 * Math.PI / 1.75 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void trigonometricAlmostHalfPITestG() {
        arg = 2 * Math.PI / 1.75 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

}
