package system;

import function.AbstractFunction;
import function.Level;

import static java.lang.Double.*;

/**
 * Created by cezar on 3/25/17.
 */
public class System extends AbstractFunction {
    private AbstractFunction tr;
    private AbstractFunction log;

    public System(double accuracy, Level lvl) {
        super(accuracy, lvl);
        tr = new Trigonometric(accuracy, lvl);
        log = new Logarithmic(accuracy, lvl);
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

