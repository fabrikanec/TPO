package function.trigonometric;

import function.AbstractFunction;

/**
 * Created by cezar on 4/3/17.
 */
public class CosStub extends AbstractFunction {
    private AbstractFunction sin = new Sin();

    public CosStub(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public CosStub(double accuracy) {
        super(accuracy);
    }

    public CosStub() {
        super();
    }

    @Override
    public double calc(double arg) {
        return Math.cos(arg);

    }
}

