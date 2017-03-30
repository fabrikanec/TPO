package function.trigonometric;

import function.AbstractFunction;

public class Csc extends AbstractFunction {
    Sin sin = new Sin();

    public Csc(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Csc(double accuracy) {
        super(accuracy);
    }

    public Csc() {
        super();
    }

    public double calc(double arg) {

        if (Math.abs(arg - Math.PI) < DELTA ||
                Math.abs(arg + Math.PI) < DELTA ||
                Math.abs(arg - 2*Math.PI) < DELTA ||
                Math.abs(arg + 2*Math.PI) < DELTA ||
                Math.abs(arg) < DELTA) {
            return Double.NaN;

        }

        if(fromTable)
            return 1 / Math.sin(arg);

        sin.setAccuracy(accuracy);
        return 1 / sin.calc(arg);
    }
}
