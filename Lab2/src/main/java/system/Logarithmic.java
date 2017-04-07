package system;

import function.AbstractFunction;
import function.Level;
import function.logarithmic.Ln;
import function.logarithmic.LogN;

import java.lang.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import static java.lang.Double.*;
import static java.lang.Math.pow;


public class Logarithmic extends AbstractFunction {
    private AbstractFunction ln;
    private AbstractFunction log2;
    private AbstractFunction log3;
    private AbstractFunction log5;
    private AbstractFunction log10;

    public Logarithmic(double accuracy, Level lvl) {
        super(accuracy, lvl);
        ln = new Ln(accuracy, lvl);
        log2 = new LogN(accuracy, 2, lvl);
        log3 = new LogN(accuracy, 3, lvl);
        log5 = new LogN(accuracy, 5, lvl);
        log10 = new LogN(accuracy, 10, lvl);
    }

    @Override
    public double calc(double arg) {

        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }
        ln.setAccuracy(getAccuracy());
        log2.setAccuracy(getAccuracy());
        log3.setAccuracy(getAccuracy());
        log5.setAccuracy(getAccuracy());
        log10.setAccuracy(getAccuracy());

        return pow(((log10.calc(arg) * log3.calc(arg) - log5.calc(arg)) * (pow(log2.calc(arg), 3))), 2) -
              (ln.calc(arg) * (pow(log5.calc(arg), 2) + pow(log10.calc(arg), 3)));
/*
        BigDecimal fst = new BigDecimal(log10.calc(arg), MathContext.UNLIMITED).multiply((new BigDecimal(log3.calc(arg), MathContext.UNLIMITED)));
        BigDecimal snd = fst.subtract(new BigDecimal(log5.calc(arg), MathContext.UNLIMITED));
        BigDecimal thd = snd.multiply(new BigDecimal(log2.calc(arg), MathContext.UNLIMITED).pow(3));
        BigDecimal fth = thd.pow(2);
        BigDecimal fith = new BigDecimal(log5.calc(arg), MathContext.UNLIMITED).pow(2).add(new BigDecimal(log10.calc(arg), MathContext.UNLIMITED).pow(3));
        BigDecimal sth  = fith.multiply(new BigDecimal(ln.calc(arg), MathContext.UNLIMITED));
        return fth.subtract(sth).doubleValue(); */
    }
}