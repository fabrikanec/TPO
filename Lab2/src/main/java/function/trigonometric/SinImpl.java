package function.trigonometric;

import function.AbstractFunction;
import function.Level;
import util.FactorialSeries;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;


public class SinImpl extends AbstractFunction {

    public SinImpl(double accuracy, Level lvl) {
        super(accuracy, lvl);
    }

    public SinImpl() {
        super();
    }

    @Override
    public double calc(double arg) {
        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        if (Math.abs(arg - Math.PI) < DELTA ) {
            return 0d;
        } else if (Math.abs(arg + Math.PI) < DELTA ) {
            return 0d;
        } else if (Math.abs(arg) < DELTA ) {
            return 0d;
        } else if (Math.abs(arg - Math.PI/2) < DELTA) {
            return 1d;
        } else if (Math.abs(arg + Math.PI/2) < DELTA) {
            return -1d;
        } else if (Math.abs(arg - 2*Math.PI) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + 2*Math.PI) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 3*Math.PI/2) < DELTA) {
            return 1d;
        } else if (Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return -1d;
        }

        /*
        double prev;
        double value = 0.0;
        int k = 0;

        do {
            prev = value;
            value += (pow(-1, k) * pow(arg, 2 * k + 1)) / FactorialSeries.factorial(2 * k + 1);
            k++;
        } while (accuracy <= abs(value - prev) && k < MAX_ITERATIONS);

        return value;
        */
        BigDecimal last;
        BigDecimal value = new BigDecimal(0d, MathContext.UNLIMITED);
        int n = 0;

        do {
            last = value;
            value = value.add((new BigDecimal(-1, MathContext.UNLIMITED).pow(n)).
                                            multiply((new BigDecimal(arg, MathContext.UNLIMITED).pow(2 * n + 1))).
                                            divide(new BigDecimal(FactorialSeries.factorial(2 * n + 1)),
                                                    15, RoundingMode.HALF_UP));
            n++;
        } while (getAccuracy() <= value.subtract(last).abs().doubleValue() && n < MAX_ITERATIONS);

        double bigDecimalValueToDoble = value.setScale(100, RoundingMode.UP).doubleValue();

        double modifiedVlue = bigDecimalValueToDoble > 1? 0.9999999999999999 : bigDecimalValueToDoble;
        modifiedVlue = modifiedVlue < -1 ? -0.9999999999999999 : modifiedVlue; //TODO make it better
        return modifiedVlue;
    }
}