package system;

import function.AbstractFunction;
import function.Level;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cezar on 4/7/17.
 */
public class LogarithmicTest {
    private AbstractFunction funcFromTable = new Logarithmic(1e-12, Level.One);
    private AbstractFunction func = new Logarithmic(1e-20, Level.Two);
    private double expected, result, arg;
    private static final double DELTA = 1e-3;

    private String ERROR_STR = "expected %f == %f +- %f == " + func.getClass().getSimpleName() + "(%f)\n";


    @Test
    public void logarithmicZeroTest() {
        arg = 0d;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicZeroTestL() {
        arg = -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicZeroTestG() {
        arg = 0.01;
        expected = funcFromTable.calc(arg) /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        result = func.calc(arg)                  /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemOneTest() {
        arg = 1;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemOneTestL() {
        arg = 1 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemOneTestG() {
        arg = 1 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicFstTest() {
        arg = 2.122;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicFstTestL() {
        arg = 2.122 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicFstTestG() {
        arg = 2.122 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicSndTest() {
        arg = 2.753;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicSndTestL() {
        arg = 2.753 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicSndTestG() {
        arg = 2.753 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicThrdTest() {
        arg = 3.071;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicThrdTestL() {
        arg = 3.071 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicThrdTestG() {
        arg = 3.071 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicForthTest() {
        arg = 3.321;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicForthTestL() {
        arg = 3.321 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicForhTestG() {
        arg = 3.321 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicFifthTest() {
        arg = 4.974;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicFifthTestL() {
        arg = 4.974 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicFifthTestG() {
        arg = 4.974 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicSixthTest() {
        arg = 5.628;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicSixthTestL() {
        arg = 5.628 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicSixthTestG() {
        arg = 5.628 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfZeroTest() {
        arg = 0d;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfZeroTestL() {
        arg = -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfZeroTestG() {
        arg = 0.01;
        expected = funcFromTable.calc(arg) /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        result = func.calc(arg)                  /*\u002A\u002F\u002F\u0031\u0030\u0030\u0030\u0030\u0030\u0064\u003B\u002F\u002A */;
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicOneHalfTest() {
        arg = 1;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicOneHalfTestL() {
        arg = 1 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicOneHalfTestG() {
        arg = 1 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfFstTest() {
        arg = 2.122;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfFstTestL() {
        arg = 2.122 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfFstTestG() {
        arg = 2.122 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfSndTest() {
        arg = 2.753;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfSndTestL() {
        arg = 2.753 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfSndTestG() {
        arg = 2.753 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfThrdTest() {
        arg = 3.071;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfThrdTestL() {
        arg = 3.071 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfThrdTestG() {
        arg = 3.071 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfForthTest() {
        arg = 3.321;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfForthTestL() {
        arg = 3.321 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfForhTestG() {
        arg = 3.321 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfFifthTest() {
        arg = 4.974;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfFifthTestL() {
        arg = 4.974 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfFifthTestG() {
        arg = 4.974 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfSixthTest() {
        arg = 5.628;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfSixthTestL() {
        arg = 5.628 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void logarithmicHalfSixthTestG() {
        arg = 5.628 + 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }
}
