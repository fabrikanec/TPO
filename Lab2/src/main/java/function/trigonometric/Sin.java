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
        double cur = 0.0;
        double result = 0.0;
        int i = 0;

        do {
            prev = cur;
            cur = (pow(-1, i) * pow(arg, 2 * i + 1)) / FactorialSeries.factorial(2 * i + 1);
            i++;
            result += cur;
        } while (abs(prev - cur) > accuracy && i < MAX_ITERATIONS);

        return result;
    }
}
