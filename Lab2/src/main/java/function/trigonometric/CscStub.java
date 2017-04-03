package function.trigonometric;

import function.AbstractFunction;

/**
 * Created by cezar on 4/3/17.
 */
public class CscStub extends AbstractFunction {

    public CscStub(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public CscStub(double accuracy) {
        super(accuracy);
    }

    public CscStub() {
        super();
    }

    @Override
    public double calc(double arg) {
        return 1 / Math.sin(arg);
    }
}
