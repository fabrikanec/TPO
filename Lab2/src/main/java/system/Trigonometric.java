package system;

import function.AbstractFunction;
import function.trigonometric.*;

public class Trigonometric extends AbstractFunction {
    private AbstractFunction sin;
    private AbstractFunction cos;
    private AbstractFunction csc;
    private AbstractFunction cot;
    private AbstractFunction tan;

    public Trigonometric(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);

        sin = new Sin(accuracy, fromTable);
        cos = new Cos(accuracy, fromTable);
        csc = new Csc(accuracy, fromTable);
        cot = new Cot(accuracy, fromTable);
        tan = new Tan(accuracy, fromTable);
    }

    public Trigonometric(double accuracy) {
        super(accuracy);
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