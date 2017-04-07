package stubs;

import function.AbstractFunction;
import function.Level;
import util.BigDecimalSqrt;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Double.*;

/**
 * Created by cezar on 3/25/17.
 */
public class LnStub extends AbstractFunction {

    public LnStub(double accuracy, Level lvl) {
        super(accuracy, true, lvl);
    }

    @Override
    public double calc(double arg) {
        return Math.log(arg);
    }
}
