package function.trigonometric;

import function.AbstractFunction;
import util.FactorialSeries;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;
import static java.lang.Math.*;

public class Sin extends AbstractFunction {

    public Sin(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Sin(double accuracy) {
        super(accuracy);
    }

    public Sin() {
        super();
    }

    public double calc(double arg) {
        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        if(fromTable)
            return Math.sin(arg);
        /*
        double prev;
        double value = 0.0;
        int k = 0;

        do {
            prev = value;
            value += (pow(-1, k) * pow(arg, 2 * k + 1)) / FactorialSeries.factorial(2 * k + 1);
            k++;
        } while (accuracy <= abs(value - prev) && k < MAX_ITERATIONS);

        return value;
        */
        BigDecimal last;
        BigDecimal value = new BigDecimal(0d, MathContext.UNLIMITED);
        int n = 0;

        do {
            last = value;
            value = value.add((new BigDecimal(-1, MathContext.UNLIMITED).pow(n)).
                                            multiply((new BigDecimal(arg, MathContext.UNLIMITED).pow(2 * n + 1))).
                                            divide(new BigDecimal(FactorialSeries.factorial(2 * n + 1)),
                                                    15, RoundingMode.HALF_UP));
            n++;
        } while (accuracy <= value.subtract(last).abs().doubleValue() && n < MAX_ITERATIONS);

        return value.setScale(100, RoundingMode.UP).doubleValue();
    }
}