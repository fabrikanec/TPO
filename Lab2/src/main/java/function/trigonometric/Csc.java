package function.trigonometric;

import function.AbstractFunction;
import function.Level;

/**
 * Created by cezar on 4/7/17.
 */
public class Csc extends AbstractFunction{
    public Csc(double accuracy, Level lvl) {
        super(accuracy, lvl);
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new CscStub(getAccuracy(), level).calc(arg);
            case Two:
                return new CscImpl(getAccuracy(), level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}

