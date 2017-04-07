package function.trigonometric;

import function.AbstractFunction;
import function.Level;

import static java.lang.Double.NaN;


public class TanImpl extends AbstractFunction {
    private AbstractFunction sin;
    private AbstractFunction cos;

    public TanImpl(double accuracy, Level lvl) {
        super(accuracy, lvl);
        sin = new Sin(accuracy, lvl);
        cos = new Cos(accuracy, lvl);
    }

    public TanImpl() {
        super();
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

        return sin.calc(arg) / cos.calc(arg);
    }
}
