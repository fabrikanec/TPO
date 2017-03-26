package function.logarithmic;

import function.AbstractFunction;

/**
 * Created by cezar on 3/25/17.
 */
public class LogN extends AbstractFunction {
    public final int BASE;
    public static final int DEFAULT_BASE = 2;
    private Ln ln = new Ln();

    public LogN(double accuracy, boolean fromTable, int base) {
        super(accuracy, fromTable);
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
    }

    public LogN(double accuracy, int base) {
        super(accuracy);
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
    }

    public LogN(int base) {
        super();
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }
        BASE = base;
    }

    public LogN(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
        BASE = DEFAULT_BASE;
    }

    public LogN(double accuracy) {
        super(accuracy);
        BASE = DEFAULT_BASE;
    }

    public LogN() {
        super();
        BASE = DEFAULT_BASE;
    }

    public double calc(double arg) {

        if(fromTable)
            return Math.log(arg)/Math.log(BASE);

        ln.setAccuracy(accuracy);
        return ln.calc(arg) / ln.calc(BASE);
    }
}
