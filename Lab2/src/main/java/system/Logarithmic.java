package system;

import function.AbstractFunction;
import function.logarithmic.Ln;
import function.logarithmic.LogN;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Logarithmic extends AbstractFunction {
    private Ln ln = new Ln();
    private LogN log2 = new LogN(2);
    private LogN log3 = new LogN(3);
    private LogN log5 = new LogN(5);
    private LogN log10 = new LogN(10);

    public Logarithmic(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);

        ln = new Ln(accuracy, fromTable);
        log2 = new LogN(accuracy, fromTable, 2);
        log3 = new LogN(accuracy, fromTable, 3);
        log5 = new LogN(accuracy, fromTable, 5);
        log10 = new LogN(accuracy, fromTable, 10);
    }

    public Logarithmic(double accuracy) {
        super(accuracy);
    }

    public Logarithmic() {
        super();
    }

    @Override
    public double calc(double arg) {
        ln.setAccuracy(accuracy);
        log2.setAccuracy(accuracy);
        log3.setAccuracy(accuracy);
        log5.setAccuracy(accuracy);
        log10.setAccuracy(accuracy);

        return new BigDecimal(log10.calc(arg)).
                multiply(new BigDecimal(log3.calc(arg), MathContext.UNLIMITED)).
                subtract(new BigDecimal(log5.calc(arg), MathContext.UNLIMITED)).
                multiply(new BigDecimal(log2.calc(arg), MathContext.UNLIMITED).pow(3)).
                pow(2).subtract(new BigDecimal(ln.calc(arg), MathContext.UNLIMITED)).
                multiply(new BigDecimal(log5.calc(arg), MathContext.UNLIMITED).pow(2)).
                add(new BigDecimal(log10.calc(arg), MathContext.UNLIMITED).pow(3)).
                setScale(100, RoundingMode.UP).doubleValue();
    }
}