package function.trigonometric;

import function.AbstractFunction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Double.*;
import static java.math.BigDecimal.*;

public class Cos extends AbstractFunction {
    Sin sin = new Sin();

    public Cos(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Cos(double accuracy) {
        super(accuracy);
    }

    public Cos() {
        super();
    }

    public double calc(double arg) {

        if(fromTable)
            return Math.cos(arg);

        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        sin.setAccuracy(accuracy);

        //double unsignedCos = (sqrt(1 - pow(sin.calc(arg), 2)));
        double unsignedCos = sqrt((new BigDecimal(1, MathContext.UNLIMITED).
                                subtract(new BigDecimal(sin.calc(arg), MathContext.UNLIMITED).
                                        pow(2))), MathContext.DECIMAL128).doubleValue();
                                        //setScale(100, RoundingMode.UP).doubleValue();

        double modifiedValue = unsignedCos > 1? 0.9999999999999999 : unsignedCos;

        double tmpA = abs(abs(arg) > PI*2 ? arg % PI*2 : arg);

        if(tmpA >= 0 && tmpA <= PI/2 || tmpA >= 3*PI/2 && tmpA <= 2*PI)
            return modifiedValue;
        else
            return -modifiedValue;
    }
    /*
    private static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()), MathContext.UNLIMITED);
        System.out.println(x.doubleValue());
        System.out.println(x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0))));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }
    /*
    private static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()), MathContext.UNLIMITED);
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).
                            divide(x.multiply(new BigDecimal(2., MathContext.UNLIMITED)), 15, RoundingMode.HALF_UP).
                            setScale(100, RoundingMode.UP).doubleValue()));
    }
    */
    /*
    private static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(new BigDecimal(2), SCALE, ROUND_HALF_UP);

        }
        return x1;
    }
    */

    private static final BigDecimal TWO = BigDecimal.valueOf(2L);

    public static BigDecimal sqrt(BigDecimal x, MathContext mc) {
        BigDecimal g = x.divide(TWO, mc);
        boolean done = false;
        final int maxIterations = mc.getPrecision() + 1;
        for (int i = 0; !done && i < maxIterations; i++) {
            // r = (x/g + g) / 2
            BigDecimal r = x.divide(g, mc);
            r = r.add(g);
            r = r.divide(TWO, mc);
            done = r.equals(g);
            g = r;
        }
        return g;
    }
}

