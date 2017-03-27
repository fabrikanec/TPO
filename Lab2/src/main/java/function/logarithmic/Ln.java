package function.logarithmic;

import function.AbstractFunction;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

/**
 * Created by cezar on 3/25/17.
 */
public class Ln extends AbstractFunction {

    public Ln(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Ln(double accuracy) {
        super(accuracy);
    }

    public Ln() {
        super();
    }

    public double calc(double arg) {
        if (isNaN(arg) || arg < 0.0) {
            return NaN;
        }

        if (arg == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }

        if (arg == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }

        if(fromTable)
            return Math.log(arg);

        double x = (arg)/(arg - 1);
        double previousValue;
        double termFactor = 1/x;
        double term = 1/x;
        double value = term;
        int n = 2;
        do {
            previousValue = value;
            term *= termFactor;
            value += term / n;
            n++;
            System.out.println(value);
        } while (accuracy <= Math.abs(value - previousValue) && n < MAX_ITERATIONS);
        System.out.println(value);
        return value;

    }
}
