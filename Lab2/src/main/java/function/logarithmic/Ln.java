package function.logarithmic;

import function.AbstractFunction;
import function.Level;

/**
 * Created by cezar on 4/6/17.
 */
public class Ln extends AbstractFunction {
    public Ln(double accuracy, Level lvl) {
        super(accuracy, lvl);
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new LnStub(getAccuracy(), level).calc(arg);
            case Two:
                return new LnImpl(getAccuracy(), level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}
