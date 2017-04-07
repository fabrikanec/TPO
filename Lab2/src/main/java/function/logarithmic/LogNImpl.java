package function.logarithmic;

import function.AbstractFunction;
import function.Level;

/**
 * Created by cezar on 3/25/17.
 */
public class LogNImpl extends AbstractFunction {
    private final int BASE;
    private static final int DEFAULT_BASE = 2;
    private AbstractFunction ln;

    public LogNImpl(double accuracy, int base, Level lvl) {
        super(accuracy, lvl);
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
        ln = new LnImpl(accuracy, lvl);
    }

    public LogNImpl(int base, Level lvl) {
        super(lvl);
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
        ln = new LnImpl();
    }

    public LogNImpl(double accuracy, Level lvl) {
        super(accuracy, lvl);
        BASE = DEFAULT_BASE;
        ln = new LnImpl(accuracy, lvl);
    }

    public LogNImpl() {
        super();
        BASE = DEFAULT_BASE;
        ln = new LnImpl();
    }

    @Override
    public double calc(double arg) {

        if (Math.abs(arg - BASE) < 1e-5) {
            return 1d;
        }

        if (Math.abs(arg - 1d) < 1e-5) {
            return 0d;
        }

        ln.setAccuracy(getAccuracy());
        return ln.calc(arg) / ln.calc(BASE);
    }
}
