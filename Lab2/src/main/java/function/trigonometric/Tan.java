package function.trigonometric;

import function.AbstractFunction;

import static java.lang.Double.NaN;


public class Tan extends AbstractFunction {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public Tan(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Tan(double accuracy) {
        super(accuracy);
    }

    public Tan() {
        super();
    }

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

        if(fromTable)
            return Math.sin(arg) / Math.cos(arg);

        sin.setAccuracy(accuracy);
        cos.setAccuracy(accuracy);
        return sin.calc(arg) / cos.calc(arg);
    }
}
