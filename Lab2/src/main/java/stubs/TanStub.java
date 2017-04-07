package stubs;

/**
 * Created by cezar on 4/3/17.
 */

import function.AbstractFunction;
import function.Level;

import static java.lang.Double.NaN;

public class TanStub extends AbstractFunction {

    public TanStub(double accuracy, Level lvl) {
        super(accuracy, true, lvl);
    }

    @Override
    public double calc(double arg) {
        if (Math.abs(arg - Math.PI) < DELTA ) {
            return 0d;
        } else if (Math.abs(arg + Math.PI) < DELTA ) {
            return 0d;
        } else if (Math.abs(arg) < DELTA ) {
            return 0d;
        } else if (Math.abs(arg - Math.PI/2) < DELTA) {
            return NaN;
        } else if (Math.abs(arg + Math.PI/2) < DELTA) {
            return NaN;
        } else if (Math.abs(arg - 2*Math.PI) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + 2*Math.PI) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 3*Math.PI/2) < DELTA) {
            return NaN;
        } else if (Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return NaN;
        }

        return Math.sin(arg) / Math.cos(arg);

    }
}
