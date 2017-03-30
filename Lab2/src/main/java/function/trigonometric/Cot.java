package function.trigonometric;

import function.AbstractFunction;

import static java.lang.Math.PI;

public class Cot extends AbstractFunction {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public Cot(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Cot(double accuracy) {
        super(accuracy);
    }

    public Cot() {
        super();
    }

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

        if(fromTable)
            return Math.cos(arg) / Math.sin(arg);

        sin.setAccuracy(accuracy);
        cos.setAccuracy(accuracy);
        return cos.calc(arg) / sin.calc(arg);
    }
}
