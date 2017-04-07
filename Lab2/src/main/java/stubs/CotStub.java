package stubs;

import function.AbstractFunction;
import function.Level;

import static java.lang.Math.PI;

/**
 * Created by cezar on 4/3/17.
 */
public class CotStub extends AbstractFunction {

    public CotStub(double accuracy, Level lvl) {
        super(accuracy, true, lvl);
    }

    @Override
    public double calc(double arg) {
        if (Math.abs(arg - Math.PI) < DELTA ) {
            return Double.NaN;
        } else if (Math.abs(arg + Math.PI) < DELTA ) {
            return Double.NaN;
        } else if (Math.abs(arg) < DELTA ) {
            return Double.NaN;
        } else if (Math.abs(arg - Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 2*PI) < DELTA) {
            return Double.NaN;
        } else if (Math.abs(arg + 2*PI) < DELTA) {
            return Double.NaN;
        } else if (Math.abs(arg - 3*Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return 0d;
        }
        return Math.cos(arg) / Math.sin(arg);
    }
}
