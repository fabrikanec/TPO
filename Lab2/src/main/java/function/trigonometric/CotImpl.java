package function.trigonometric;

import function.AbstractFunction;
import function.Level;

import static java.lang.Math.PI;

public class CotImpl extends AbstractFunction {
    private AbstractFunction sin;
    private AbstractFunction cos;

    public CotImpl(double accuracy, Level lvl) {
        super(accuracy, lvl);
        sin = new Sin(accuracy, lvl);
        cos = new Cos(accuracy, lvl);
    }

    public CotImpl() {
        super();
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

        sin.setAccuracy(getAccuracy());
        cos.setAccuracy(getAccuracy());
        return cos.calc(arg) / sin.calc(arg);
    }
}
