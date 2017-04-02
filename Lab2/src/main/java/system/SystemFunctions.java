package system;

import function.AbstractFunction;
import function.logarithmic.Ln;
import function.logarithmic.LogN;
import function.trigonometric.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;

/**
 * Created by cezar on 3/25/17.
 */
public class SystemFunctions extends AbstractFunction {
    private Sin sin = new Sin();
    private Cos cos = new Cos();
    private Csc csc = new Csc();
    private Sec sec = new Sec();
    private Cot cot = new Cot();
    private Tan tan = new Tan();

    private Ln ln = new Ln();
    private LogN log2 = new LogN(2);
    private LogN log3 = new LogN(3);
    private LogN log5 = new LogN(5);
    private LogN log10 = new LogN(10);

    public SystemFunctions(double accuracy, boolean fromTable) {
        super(accuracy);
        sin = new Sin(accuracy, fromTable);
        cos = new Cos(accuracy, fromTable);
        csc = new Csc(accuracy, fromTable);
        sec = new Sec(accuracy, fromTable);
        cot = new Cot(accuracy, fromTable);
        tan = new Tan(accuracy, fromTable);

        ln = new Ln(accuracy, fromTable);
        log2 = new LogN(accuracy, fromTable, 2);
        log3 = new LogN(accuracy, fromTable, 3);
        log5 = new LogN(accuracy, fromTable, 5);
        log10 = new LogN(accuracy, fromTable, 10);
    }

    public SystemFunctions(double accuracy) {
        super(accuracy);
    }

    public SystemFunctions() {
        super();
    }

    public double calc(double arg) {
        sin.setAccuracy(accuracy);
        cos.setAccuracy(accuracy);
        csc.setAccuracy(accuracy);
        sec.setAccuracy(accuracy);
        cot.setAccuracy(accuracy);

        ln.setAccuracy(accuracy);
        log3.setAccuracy(accuracy);
        log5.setAccuracy(accuracy);
        log10.setAccuracy(accuracy);

        if (isInfinite(arg) || isNaN(arg)) {
            return NaN;
        }

        if (arg <= 0) {
            return (((((cot.calc(arg) -
                    csc.calc(arg)) *
                    tan.calc(arg)) *
                    csc.calc(arg)) -
                    sin.calc(arg)) /
                    (cos.calc(arg) +
                    cos.calc(arg)));
        } else if (arg > 0) {
            //return pow(((log10.calc(arg) * log3.calc(arg) - log5.calc(arg)) * (pow(log2.calc(arg), 3))), 2) -
              //      (ln.calc(arg) * (pow(log5.calc(arg), 2) + pow(log10.calc(arg), 3)));
            return new BigDecimal(log10.calc(arg)).
                        multiply(new BigDecimal(log3.calc(arg), MathContext.UNLIMITED)).
                        subtract(new BigDecimal(log5.calc(arg), MathContext.UNLIMITED)).
                        multiply(new BigDecimal(log2.calc(arg), MathContext.UNLIMITED).pow(3)).
                        pow(2).subtract(new BigDecimal(ln.calc(arg), MathContext.UNLIMITED)).
                        multiply(new BigDecimal(log5.calc(arg), MathContext.UNLIMITED).pow(2)).
                        add(new BigDecimal(log10.calc(arg), MathContext.UNLIMITED).pow(3)).
                        setScale(100, RoundingMode.UP).doubleValue();
        }

        return NaN;
    }
}

