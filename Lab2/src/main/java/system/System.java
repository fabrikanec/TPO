package system;

import function.AbstractFunction;

import static java.lang.Double.*;

/**
 * Created by cezar on 3/25/17.
 */
public class System extends AbstractFunction {
    private AbstractFunction tr;
    private AbstractFunction log;

    public System(double accuracy) {
        super(accuracy);
        tr = new Trigonometric(accuracy);
        log = new Logarithmic(accuracy);
    }

    public double calc(double arg) {
        if (isInfinite(arg) || isNaN(arg)) {
            return NaN;
        }

        if (arg <= 0) {
            return tr.calc(arg);
        } else {
            return log.calc(arg);
        }
    }
}

