package function.trigonometric;

import function.AbstractFunction;
import function.Level;

import static java.lang.Double.NaN;
import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;

/**
 * Created by cezar on 4/3/17.
 */
public class CosStub extends AbstractFunction {

    public CosStub(double accuracy, Level lvl) {
        super(accuracy, true, lvl);
    }

    @Override
    public double calc(double arg) {
        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        if (Math.abs(arg - Math.PI) < DELTA ) {
            return -1d;
        } else if (Math.abs(arg + Math.PI) < DELTA ) {
            return -1d;
        } else if (Math.abs(arg) < DELTA ) {
            return 1d;
        } else if (Math.abs(arg - Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 3*Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 2*Math.PI) < DELTA) {
            return 1d;
        } else if (Math.abs(arg + 2*Math.PI) < DELTA) {
            return 1d;
        }

        return Math.cos(arg);

    }
}

