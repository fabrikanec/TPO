package function.trigonometric;

import function.AbstractFunction;

public class Tan extends AbstractFunction {
    Sin sin = new Sin();
    Cos cos = new Cos();

    public Tan(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Tan(double accuracy) {
        super(accuracy);
    }

    public Tan() {
        super();
    }

    public double calc(double arg) {

        if(fromTable)
            return Math.sin(arg) / Math.cos(arg);

        sin.setAccuracy(accuracy);
        cos.setAccuracy(accuracy);
        return sin.calc(arg) / cos.calc(arg);
    }
}
