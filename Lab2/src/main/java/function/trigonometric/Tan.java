package function.trigonometric;

import function.AbstractFunction;
import function.Level;
import implementation.trigonometric.TanImpl;
import stubs.TanStub;

/**
 * Created by cezar on 4/7/17.
 */
public class Tan extends AbstractFunction {
    public Tan(double accuracy, Level lvl) {
        super(accuracy, lvl);
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new TanStub(getAccuracy(), level).calc(arg);
            case Two:
                return new TanImpl(getAccuracy(), level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}
