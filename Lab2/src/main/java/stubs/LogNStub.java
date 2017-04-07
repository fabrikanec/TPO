package stubs;

import function.AbstractFunction;
import function.Level;

/**
 * Created by cezar on 3/25/17.
 */
public class LogNStub extends AbstractFunction {
    public final int BASE;
    public static final int DEFAULT_BASE = 2;

    public LogNStub(double accuracy, int base, Level lvl) {
        super(accuracy, true, lvl);
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
    }


    public LogNStub(double accuracy, Level lvl) {
        super(accuracy, true, lvl);
        BASE = DEFAULT_BASE;
    }

    @Override
    public double calc(double arg) {

        return Math.log(arg) / Math.log(BASE);
    }
}
