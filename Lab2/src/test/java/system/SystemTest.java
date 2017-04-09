package system;

import function.AbstractFunction;
import function.Level;
import function.logarithmic.Ln;
import function.logarithmic.LogN;
import function.trigonometric.*;
import org.junit.Ignore;
import org.junit.Test;
import util.Writer;

import static org.junit.Assert.assertEquals;

/**
 * Created by cezar on 3/26/17.
 */
public class SystemTest {
    private AbstractFunction funcFromTable = new System(1e-12, Level.One);
    private AbstractFunction func = new System(1e-20, Level.Two);
    private double expected, result, arg;
    private static final double DELTA = 1e-3;

    private String ERROR_STR = "expected %f == %f +- %f == " + func.getClass().getSimpleName() + "(%f)\n";

    @Test
    public void systemNegInfTest() {
        arg = Double.NEGATIVE_INFINITY;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemPosInfTest() {
        arg = Double.POSITIVE_INFINITY;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemZeroTest() {
        arg = 0d;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemZeroTestL() {
        arg = -0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemZeroTestG() {
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
    public void systemMTwoPiTest() {
        arg = -Math.PI*2;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemMTwoPiTestL() {
        arg = - Math.PI * 2 - 0.01;
        expected = funcFromTable.calc(arg);
        result = func.calc(arg);
        assertEquals(String.format(ERROR_STR, expected, result, DELTA, arg),
                expected,
                result,
                DELTA);
    }

    @Test
    public void systemMTwoPiTestG() {
        arg = - Math.PI * 2 + 0.01;
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

        writer.setFunction(new Sin(1e-4, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new Cos(1e-4, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new Cot(1e-4, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new Tan(1e-4, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new Csc(1e-4, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new Ln(1e-4, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new LogN(1e-4, 2, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new LogN(1e-4, 3, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new LogN(1e-4, 5, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new LogN(1e-4, 10, Level.Two));
        writer.toCSVFile(-Math.PI, Math.PI, 1e-4);

        writer.setFunction(new System(1e-4, Level.Two));
        writer.toCSVFile(-2*Math.PI, 5.0, 1e-4);

        Writer.generateCanonicalCSVFiles(- Math.PI, Math.PI, .0, 12.0, 1e-5);

        Writer.generateCanonicalCSVFiles(-2.1 * Math.PI, 0.1, 0, 3, 1e-6);
    }
}