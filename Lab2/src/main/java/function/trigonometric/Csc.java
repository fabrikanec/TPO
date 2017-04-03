package function.trigonometric;

import function.AbstractFunction;

public class Csc extends AbstractFunction {
    private AbstractFunction sin = new Sin();

    public Csc(double accuracy) {
        super(accuracy);
    }

    public Csc() {
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
