package function.trigonometric;

import com.fasterxml.jackson.core.sym.NameN;
import function.AbstractFunction;

import java.util.function.DoubleBinaryOperator;

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

        if (Math.abs(arg - Math.PI/2) < DELTA ||
                Math.abs(arg + Math.PI/2) < DELTA ||
                Math.abs(arg - 3*Math.PI/2) < DELTA ||
                Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return Double.NaN;
        }

        if(fromTable)
            return 1 / Math.cos(arg);


        cos.setAccuracy(accuracy);
        return 1 / cos.calc(arg);
    }
}
