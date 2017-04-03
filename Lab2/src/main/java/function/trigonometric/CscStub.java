package function.trigonometric;

import function.AbstractFunction;

/**
 * Created by cezar on 4/3/17.
 */
public class CscStub extends AbstractFunction {

    public CscStub(double accuracy) {
        super(accuracy, true);
    }

    @Override
    public double calc(double arg) {
        if (Math.abs(arg - Math.PI) < DELTA ||
                Math.abs(arg + Math.PI) < DELTA ||
                Math.abs(arg - 2*Math.PI) < DELTA ||
                Math.abs(arg + 2*Math.PI) < DELTA ||
                Math.abs(arg) < DELTA) {
            return Double.NaN;
        }
        return 1 / Math.sin(arg);
    }
}
