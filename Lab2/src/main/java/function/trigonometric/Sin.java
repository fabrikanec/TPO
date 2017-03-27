package function.trigonometric;

import function.AbstractFunction;
import util.FactorialSeries;

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
        if (isNaN(arg)) {
            return NaN;
        }

        if(fromTable)
            return Math.sin(arg);

        double prev;
        double value = 0.0;
        int k = 0;

        do {
            prev = value;
            value += (pow(-1, k) * pow(arg, 2 * k + 1)) / FactorialSeries.factorial(2 * k + 1);
            k++;
        } while (accuracy <= abs(value - prev) && k < MAX_ITERATIONS);

        return value;
    }
}