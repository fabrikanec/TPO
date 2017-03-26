package function.trigonometric;

import function.AbstractFunction;

public class Sec extends AbstractFunction {
    Cos cos = new Cos();

    public Sec(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Sec(double accuracy) {
        super(accuracy);
    }

    public Sec() {
        super();
    }

    public double calc(double arg) {

        if(fromTable)
            return 1 / Math.cos(arg);

        cos.setAccuracy(accuracy);
        return 1 / cos.calc(arg);
    }
}
