package function.trigonometric;

import function.AbstractFunction;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class Cos extends AbstractFunction {
    Sin sin = new Sin();

    public Cos(double accuracy, boolean fromTable) {
        super(accuracy, fromTable);
    }

    public Cos(double accuracy) {
        super(accuracy);
    }

    public Cos() {
        super();
    }

    public double calc(double arg) {

        if(fromTable)
            return Math.cos(arg);

        sin.setAccuracy(accuracy);

        //double unsignedCos = (sqrt(1 - pow(sin.calc(arg), 2)));
        double unsignedCos = BigDecimal.ONE.subtract(BigDecimal.valueOf(sin.calc(arg))
                             .pow(2, MathContext.DECIMAL128), MathContext.DECIMAL128)
                             .pow(-2, MathContext.DECIMAL128).doubleValue();

        double tmpA = abs(abs(arg) > PI*2 ? arg % PI*2 : arg);

        if(tmpA >= 0 && tmpA <= PI/2 || tmpA >= 3*PI/2 && tmpA <= 2*PI)
            return unsignedCos;
        else
            return -unsignedCos;
    }
}
