package implementation.trigonometric;

import function.AbstractFunction;
import function.Level;
import function.trigonometric.Sin;

public class CscImpl extends AbstractFunction {
    private AbstractFunction sin;

    public CscImpl(double accuracy, Level lvl) {
        super(accuracy, lvl);
        sin = new Sin(accuracy, lvl);
    }

    public CscImpl() {
        super();
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

        sin.setAccuracy(getAccuracy());
        return 1 / sin.calc(arg);
    }
}
