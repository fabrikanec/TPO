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
        double x = 1;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionOne() { // x = 1
        double x = 1;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionOneG() { // x = 1 + 0.01
        double x = 1;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionNaN() { // x < -1 || x > 1
        double x = 2;
        assertEquals(Double.NaN, Function.count(x, EPS), DELTA);
    }
    @Test
    public void testFunctionEqMinusWrongTaylor() { //-1 < x < -0.95
        double x = -0.98;
        double x1 = -0.97;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
        assertEquals(Math.asin(x1), Function.count(x1, EPS), DELTA);
    }
    @Test
    public void testFunctionEquMinusTaylor() { // -0.95 < x < 0
        double x = -0.5;
        double x1 = -0.4;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
        assertEquals(Math.asin(x1), Function.count(x1, EPS), DELTA);
    }
    @Test
    public void testFunctionEqTaylor() { // 0 < x < 0.95
        double x = 0.5;
        double x1 = 0.4;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
        assertEquals(Math.asin(x1), Function.count(x1, EPS), DELTA);
    }
    @Test
    public void testFunctionEqWrongTaylor() { // 0.95 < x < 1
        double x = 0.97;
        double x1 = 0.98;
        assertEquals(Math.asin(x), Function.count(x, EPS), DELTA);
        assertEquals(Math.asin(x1), Function.count(x1, EPS), DELTA);
    }
}
