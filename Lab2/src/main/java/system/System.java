package system;

import function.AbstractFunction;
import function.logarithmic.Ln;
import function.logarithmic.LogN;
import function.trigonometric.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;

/**
 * Created by cezar on 3/25/17.
 */
public class System extends AbstractFunction {
    private AbstractFunction tr = new Trigonometric();
    private AbstractFunction log = new Logarithmic();

    public System(double accuracy, boolean fromTable) {
        super(accuracy);

        tr = new Trigonometric(accuracy, fromTable);
        log = new Logarithmic(accuracy, fromTable);
    }

    public System(double accuracy) {
        super(accuracy);
    }

    public System() {
        super();
    }

    public double calc(double arg) {
        if (isInfinite(arg) || isNaN(arg)) {
            return NaN;
        }

        if (arg <= 0) {
            return tr.calc(arg);
        } else if (arg > 0) {
            return log.calc(arg);
        }

        return NaN;
    }
}

