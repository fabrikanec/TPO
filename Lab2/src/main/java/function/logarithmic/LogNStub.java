package function.logarithmic;

import function.AbstractFunction;

/**
 * Created by cezar on 3/25/17.
 */
public class LogNStub extends AbstractFunction {
    public final int BASE;
    public static final int DEFAULT_BASE = 2;

    public LogNStub(double accuracy, int base) {
        super(accuracy, true);
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
    }


    public LogNStub(double accuracy) {
        super(accuracy, true);
        BASE = DEFAULT_BASE;
    }

    @Override
    public double calc(double arg) {

        return Math.log(arg) / Math.log(BASE);
    }
}
