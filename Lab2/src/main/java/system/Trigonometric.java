package system;

import function.AbstractFunction;
import function.trigonometric.*;

public class Trigonometric extends AbstractFunction {
    private Sin sin = new Sin();
    private Cos cos = new Cos();
    private Csc csc = new Csc();
    private Cot cot = new Cot();
    private Tan tan = new Tan();

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
        sin.setAccuracy(accuracy);
        cos.setAccuracy(accuracy);
        csc.setAccuracy(accuracy);
        cot.setAccuracy(accuracy);

        return (((((cot.calc(arg) -
                csc.calc(arg)) *
                tan.calc(arg)) *
                csc.calc(arg)) -
                sin.calc(arg)) /
                (cos.calc(arg) + cos.calc(arg)));
    }
}