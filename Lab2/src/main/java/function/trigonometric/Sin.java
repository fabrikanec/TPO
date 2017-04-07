package function.trigonometric;

import function.AbstractFunction;
import function.Level;
import implementation.trigonometric.SinImpl;
import stubs.SinStub;

/**
 * Created by cezar on 4/7/17.
 */
public class Sin extends AbstractFunction {
    public Sin(double accuracy, Level lvl) {
        super(accuracy, lvl);
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new SinStub(getAccuracy(), level).calc(arg);
            case Two:
                return new SinImpl(getAccuracy(), level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}
