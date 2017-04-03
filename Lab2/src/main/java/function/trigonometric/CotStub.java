package function.trigonometric;

import function.AbstractFunction;

/**
 * Created by cezar on 4/3/17.
 */
public class CotStub extends AbstractFunction {

    public CotStub(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public CotStub(double accuracy) {
        super(accuracy);
    }

    public CotStub() {
        super();
    }

    @Override
    public double calc(double arg) {
        return Math.cos(arg) / Math.sin(arg);
    }
}
