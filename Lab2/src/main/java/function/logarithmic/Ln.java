package function.logarithmic;

import function.AbstractFunction;

import static java.lang.Double.*;

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

        double value = 0;
        double preValue;
        int n = 1;
        int k = 1;
        if (Math.abs(arg - 1) <= 1) {
            do {
                preValue = value;
                value -= ((Math.pow(-1, n) * Math.pow(arg - 1, n)) / n);
                n++;
            } while (accuracy <= Math.abs(value - preValue) && n < MAX_ITERATIONS);
        } else {
            do {
                preValue = value;
                value -=((Math.pow(-1, k) * Math.pow(arg - 1, -k)) / k);
                k++;
            } while (accuracy <= Math.abs(value - preValue) && k < MAX_ITERATIONS);
            value += calc(arg - 1);
        }

        return value;
    }
}
