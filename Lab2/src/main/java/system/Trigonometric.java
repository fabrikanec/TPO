package system;

import function.AbstractFunction;
import function.trigonometric.*;

public class Trigonometric extends AbstractFunction {
    private AbstractFunction sin;
    private AbstractFunction cos;
    private AbstractFunction csc;
    private AbstractFunction cot;
    private AbstractFunction tan;

    public Trigonometric(double accuracy) {
        super(accuracy);
        sin = new Sin(accuracy);
        cos = new Cos(accuracy);
        csc = new Csc(accuracy);
        cot = new Cot(accuracy);
        tan = new Tan(accuracy);
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