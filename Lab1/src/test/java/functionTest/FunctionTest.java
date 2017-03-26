package functionTest;

import org.junit.Test;
import static org.junit.Assert.*;
import function.*;

/**
 * Created by root on 3/20/17.
 */
public class FunctionTest {
    public static final double EPS = 1E-7;
    public static final double DELTA = 1E-6;

    @Test
    public void testFunctionMinusOneL() { // x = -1 - 0.01
        double x = -1.01;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionMinusOne() { // x = -1
        double x = -1;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionMinusOneG() { // x = -1 + 0.01
        double x = -0.99;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionMinus0Dot95L() { // x = -0.95 - 0.01
        double x = -0.96;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionMinus0Dot95() { // x = -0.95
        double x = -0.95;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionMinus0Dot95G() { // x = -0.95 + 0.01
        double x = -0.94;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunction0L() { // x = 0 - 0.01
        double x = -0.01;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunction0() { // x = 0
        double x = 0;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunction0G() { // x = 0 + 0.01
        double x = 0.01;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunction0Dot95L() { // x = 0.95 - 0.01
        double x = 0.94;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunction0Dot95() { // x = 0.95
        double x = 0.95;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunction0Dot95G() { // x = 0.95 + 0.01
        double x = 0.96;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionOneL() { // x = 1 - 0.01
        double x = 0.99 ;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionOne() { // x = 1
        double x = 1;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionOneG() { // x = 1 + 0.01
        double x = 1.01;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionInfL() { // x = INF - 0.01
        double x = Double.POSITIVE_INFINITY - 1;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionInf() { // x = INF
        double x = Double.POSITIVE_INFINITY;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionInfG() { // x = INF + 0.01
        double x = Double.POSITIVE_INFINITY + 1;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionMinusInfL() { // x = -INF - 0.01
        double x = Double.NEGATIVE_INFINITY - 1;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionMinusInf() { // x = -INF
        double x = Double.NEGATIVE_INFINITY;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionMinusInfG() { // x = -INF + 0.01
        double x = Double.NEGATIVE_INFINITY + 1;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionNaN() { // x < -1 || x > 1
        double x = 2;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionEqMinusWrongTaylorFirst() { //-1 < x < -0.95
        double x = -0.98;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEqMinusWrongTaylorSecond() { //-1 < x < -0.95
        double x = -0.97;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEquMinusTaylorFirst() { // -0.95 < x < 0
        double x = -0.5;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEquMinusTaylorSecond() { // -0.95 < x < 0
        double x = -0.4;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEqTaylorFirst() { // 0 < x < 0.95
        double x = 0.5;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEqTaylorSecond() { // 0 < x < 0.95
        double x = 0.4;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEqWrongTaylorFirst() { // 0.95 < x < 1
        double x = 0.97;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }

    @Test
    public void testFunctionEqWrongTaylorSecond() { // 0.95 < x < 1
        double x = 0.98;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
}
