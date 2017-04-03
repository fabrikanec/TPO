package function.logarithmic;

import function.AbstractFunction;
import util.BigDecimalSqrt;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Double.*;

/**
 * Created by cezar on 3/25/17.
 */
public class Ln extends AbstractFunction {

    public Ln(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Ln(double accuracy) {
        super(accuracy);
    }

    public Ln() {
        super();
    }

    @Override
    public double calc(double arg) {
        if (isNaN(arg) || arg < 0.0) {
            return NaN;
        }

        if (arg == POSITIVE_INFINITY) {
            return POSITIVE_INFINITY;
        }

        if (arg == 0.0) {
            return NEGATIVE_INFINITY;
        }

        if(isFromTable())
            return Math.log(arg);

        //TODO change fromTable to stub
        double value = 0;
        double preValue;
        int n = 1;
        int k = 1;
        if (Math.abs(arg - 1) <= 1) {
            do {
                preValue = value;
                value -= ((Math.pow(-1, n) * Math.pow(arg - 1, n)) / n);
                n++;
            } while (getAccuracy() <= Math.abs(value - preValue) && n < MAX_ITERATIONS);
        } else {
            do {
                preValue = value;
                value -=((Math.pow(-1, k) * Math.pow(arg - 1, -k)) / k);
                k++;
            } while (getAccuracy() <= Math.abs(value - preValue) && k < MAX_ITERATIONS);
            value += calc(arg - 1);
        }

        return value;
        /*
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal preValue;
        int n = 1;
        int k = 1;
        if (Math.abs(arg - 1) <= 1) {
            do {
                preValue = value;
                value = value.subtract(BigDecimal.valueOf((Math.pow(-1, n) * Math.pow(arg - 1, n)) / n), MathContext.UNLIMITED);
                n++;
            } while (getAccuracy() <= value.subtract(preValue).abs().doubleValue() && n < MAX_ITERATIONS);
        } else {
            do {
                preValue = value;
                value = value.subtract(BigDecimal.valueOf((Math.pow(-1, k) * Math.pow(arg - 1, -k)) / k), MathContext.UNLIMITED);
                k++;
            } while (getAccuracy() <= value.subtract(preValue).abs().doubleValue() && k < MAX_ITERATIONS);
            value = value.add(BigDecimal.valueOf(calc(arg - 1)), MathContext.UNLIMITED);
        }


        return value.doubleValue();
        //return value; */
    }
}
