package function.trigonometric;

import function.AbstractFunction;
import function.Level;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Math.*;
import static java.lang.Double.*;
import static util.BigDecimalSqrt.sqrt;

public class CosImpl extends AbstractFunction {
    private AbstractFunction sin;

    public CosImpl(double accuracy, Level lvl) {
        super(accuracy, lvl);
        sin = new Sin(accuracy, lvl);
    }

    public CosImpl() {
        super();
    }

    @Override
    public double calc(double arg) {

        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        if (Math.abs(arg - Math.PI) < DELTA ) {
            return -1d;
        } else if (Math.abs(arg + Math.PI) < DELTA ) {
            return -1d;
        } else if (Math.abs(arg) < DELTA ) {
            return 1d;
        } else if (Math.abs(arg - Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 3*Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 2*Math.PI) < DELTA) {
            return 1d;
        } else if (Math.abs(arg + 2*Math.PI) < DELTA) {
            return 1d;
        }

        sin.setAccuracy(getAccuracy());

        //double unsignedCos = (sqrt(1 - pow(sin.calc(arg), 2)));
        double unsignedCos = sqrt((new BigDecimal(1, MathContext.UNLIMITED).
                                subtract(new BigDecimal(sin.calc(arg), MathContext.UNLIMITED).
                                        pow(2))), MathContext.DECIMAL128).doubleValue();
                                        //setScale(10, RoundingMode.UP).doubleValue();

        double modifiedValue = unsignedCos > 1? 0.9999999999999999 : unsignedCos; //TODO make it better

        double tmpA = abs(abs(arg) > PI*2 ? arg % PI*2 : arg);

        if(tmpA >= 0 && tmpA <= PI/2 || tmpA >= 3*PI/2 && tmpA <= 2*PI)
            return modifiedValue;
        else
            return -modifiedValue;
    }
}

