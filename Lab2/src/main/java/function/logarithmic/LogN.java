package function.logarithmic;

import function.AbstractFunction;
import function.Level;
import implementation.logarithmic.LogNImpl;
import stubs.LogNStub;

/**
 * Created by cezar on 4/6/17.
 */
public class LogN extends AbstractFunction {

    private final int BASE;
    private static final int DEFAULT_BASE = 2;

    public LogN(double accuracy, Level lvl) {
        super(accuracy, lvl);
        BASE = DEFAULT_BASE;
        level = lvl;

    }

    public LogN(double accuracy, int base, Level lvl) {
        super(accuracy, lvl);
        BASE = base;
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new LogNStub(getAccuracy(), BASE, level).calc(arg);
            case Two:
                return new LogNImpl(getAccuracy(), BASE, level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}