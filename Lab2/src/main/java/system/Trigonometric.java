package system;

import function.AbstractFunction;
import function.Level;
import function.trigonometric.*;

public class Trigonometric extends AbstractFunction {
    private AbstractFunction sin;
    private AbstractFunction cos;
    private AbstractFunction csc;
    private AbstractFunction cot;
    private AbstractFunction tan;

    public Trigonometric(double accuracy, Level lvl) {
        super(accuracy, lvl);
        sin = new Sin(accuracy, lvl);
        cos = new Cos(accuracy, lvl);
        csc = new Csc(accuracy, lvl);
        cot = new Cot(accuracy, lvl);
        tan = new Tan(accuracy, lvl);
    }

    public Trigonometric() {
        super();
    }

    @Override
    public double calc(double arg) {
        sin.setAccuracy(getAccuracy());
        cos.setAccuracy(getAccuracy());
        csc.setAccuracy(getAccuracy());
        cot.setAccuracy(getAccuracy());

        return (((((cot.calc(arg) -
                csc.calc(arg)) *
                tan.calc(arg)) *
                csc.calc(arg)) -
                sin.calc(arg)) /
                (cos.calc(arg) + cos.calc(arg)));
    }
}