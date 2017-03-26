package function.trigonometric;

import function.AbstractFunction;

public class Cot extends AbstractFunction {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public Cot(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Cot(double accuracy) {
        super(accuracy);
    }

    public Cot() {
        super();
    }

    public double calc(double arg) {

        if(fromTable)
            return Math.cos(arg) / Math.sin(arg);

        sin.setAccuracy(accuracy);
        cos.setAccuracy(accuracy);
        return cos.calc(arg) / sin.calc(arg);
    }
}
