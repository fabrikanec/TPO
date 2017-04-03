package function.trigonometric;

import function.AbstractFunction;

import static java.lang.Math.PI;

public class Cot extends AbstractFunction {
    private AbstractFunction sin = new Sin();
    private AbstractFunction cos = new Cos();

    public Cot(double accuracy) {
        super(accuracy);
    }

    public Cot() {
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
