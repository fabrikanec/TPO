package function.trigonometric;

import function.AbstractFunction;
import function.Level;
import implementation.trigonometric.CotImpl;
import stubs.CotStub;

/**
 * Created by cezar on 4/7/17.
 */
public class Cot extends AbstractFunction {
    public Cot(double accuracy, Level lvl) {
        super(accuracy, lvl);
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new CotStub(getAccuracy(), level).calc(arg);
            case Two:
                return new CotImpl(getAccuracy(), level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}

