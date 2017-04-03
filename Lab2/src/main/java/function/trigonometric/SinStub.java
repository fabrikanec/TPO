package function.trigonometric;

import function.AbstractFunction;

/**
 * Created by cezar on 4/3/17.
 */
public class SinStub extends AbstractFunction {

    public SinStub(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public SinStub(double accuracy) {
        super(accuracy);
    }

    public SinStub() {
        super();
    }

    @Override
    public double calc(double arg) {
        return Math.sin(arg);
    }
}