package function.trigonometric;

import function.AbstractFunction;
import function.Level;
import function.logarithmic.LnImpl;
import function.logarithmic.LnStub;

/**
 * Created by cezar on 4/7/17.
 */
public class Cos extends AbstractFunction {
    public Cos(double accuracy, Level lvl) {
        super(accuracy, lvl);
        level = lvl;
    }

    @Override
    public double calc(double arg) {
        switch (level) {
            case One:
                return new CosStub(getAccuracy(), level).calc(arg);
            case Two:
                return new CosImpl(getAccuracy(), level).calc(arg);
            case Three:
                break;
        }
        throw new RuntimeException();
    }
}
