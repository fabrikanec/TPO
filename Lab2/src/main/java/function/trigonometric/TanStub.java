package function.trigonometric;

/**
 * Created by cezar on 4/3/17.
 */

import function.AbstractFunction;

public class TanStub extends AbstractFunction {

    public TanStub(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public TanStub(double accuracy) {
        super(accuracy);
    }

    public TanStub() {
        super();
    }

    @Override
    public double calc(double arg) {
        return Math.sin(arg) / Math.cos(arg);

    }
}
