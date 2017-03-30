package function;

import java.util.Map;

import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;
import util.Writer;

/**
 * Created by cezar on 3/25/17.
 */
public abstract class AbstractFunction {

    protected static final double DELTA = 1e-5;
    public static final int MAX_ITERATIONS = 500000;
    private static final double DEFAULT_ACCURACY = 1e-4;

    protected double accuracy;
    protected boolean fromTable = false;
    protected Map<Double, Double> canonicalResTable;

    private Writer writer = new Writer();

    public AbstractFunction(double accuracy, boolean fromTable) {
        if (isNaN(accuracy) || isInfinite(accuracy)) {
            throw new IllegalArgumentException("accuracy");
        }

        this.fromTable = fromTable;
        this.accuracy = accuracy;

        if(fromTable)
            canonicalResTable = writer.parseCanonicalCSVFile();
    }

    public AbstractFunction(double accuracy) {
        this(accuracy, false);
    }

    public AbstractFunction() {
        this(DEFAULT_ACCURACY, false);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        if (isNaN(accuracy) || isInfinite(accuracy)) {
            throw new IllegalArgumentException("accuracy");
        }

        this.accuracy = accuracy;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public abstract double calc(double arg);
}
