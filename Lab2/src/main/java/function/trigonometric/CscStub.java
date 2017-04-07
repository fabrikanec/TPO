package function.trigonometric;

import function.AbstractFunction;
import function.Level;

/**
 * Created by cezar on 4/3/17.
 */
public class CscStub extends AbstractFunction {

    public CscStub(double accuracy, Level lvl) {
        super(accuracy, true, lvl);
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
