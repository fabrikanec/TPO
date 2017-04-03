package system;

import function.AbstractFunction;
import function.logarithmic.Ln;
import function.logarithmic.LogN;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.pow;


public class Logarithmic extends AbstractFunction {
    private AbstractFunction ln;
    private AbstractFunction log2;
    private AbstractFunction log3;
    private AbstractFunction log5;
    private AbstractFunction log10;


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
        ln.setAccuracy(getAccuracy());
        log2.setAccuracy(getAccuracy());
        log3.setAccuracy(getAccuracy());
        log5.setAccuracy(getAccuracy());
        log10.setAccuracy(getAccuracy());

        //return pow(((log10.calc(arg) * log3.calc(arg) - log5.calc(arg)) * (pow(log2.calc(arg), 3))), 2) -
          //    (ln.calc(arg) * (pow(log5.calc(arg), 2) + pow(log10.calc(arg), 3)));

        BigDecimal fst = new BigDecimal(log10.calc(arg), MathContext.UNLIMITED).multiply((new BigDecimal(log3.calc(arg), MathContext.UNLIMITED)));
        BigDecimal snd = fst.subtract(new BigDecimal(log5.calc(arg), MathContext.UNLIMITED));
        BigDecimal thd = snd.multiply(new BigDecimal(log2.calc(arg), MathContext.UNLIMITED).pow(3));
        BigDecimal fth = thd.pow(2);
        BigDecimal fith = new BigDecimal(log5.calc(arg), MathContext.UNLIMITED).pow(2).add(new BigDecimal(log10.calc(arg), MathContext.UNLIMITED).pow(3));
        BigDecimal sth  = fith.multiply(new BigDecimal(ln.calc(arg), MathContext.UNLIMITED));
        double res = fth.subtract(sth).doubleValue();
        return res;
    }
}