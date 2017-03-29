package function.trigonometric;

import function.AbstractFunction;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
                                        pow(2))))
                                        .setScale(100, RoundingMode.UP).doubleValue();

        double tmpA = abs(abs(arg) > PI*2 ? arg % PI*2 : arg);

        if(tmpA >= 0 && tmpA <= PI/2 || tmpA >= 3*PI/2 && tmpA <= 2*PI)
            return unsignedCos;
        else
            return -unsignedCos;
    }

    private static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()), MathContext.UNLIMITED);
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }

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

}

