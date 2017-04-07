package function;

import java.util.Map;
import util.Writer;

import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;

/**
 * Created by cezar on 3/25/17.
 */
public abstract class AbstractFunction {

    protected Level level;
    private static final Level DEFAULT_LEVEL = Level.One;
    public static final double DELTA = 1e-4;
    public static final int MAX_ITERATIONS = 1_000_000;
    private static final double DEFAULT_ACCURACY = 1e-7;

    private double accuracy;
    private Map<Double, Double> canonicalResTable;
    private Writer writer = new Writer();

    public AbstractFunction(double accuracy, boolean fromTable, Level lvl) {
        if (isNaN(accuracy) || isInfinite(accuracy)) {
            throw new IllegalArgumentException("accuracy");

        }
        level = lvl;
        this.accuracy = accuracy;

        if(fromTable)
            canonicalResTable = writer.parseCanonicalCSVFile();
    }

    public AbstractFunction(double accuracy, Level lvl) {
        this(accuracy, false, lvl);

    }

    public AbstractFunction() {
        this(DEFAULT_ACCURACY, false, DEFAULT_LEVEL);
    }

    public AbstractFunction(Level lvl) {
        this(DEFAULT_ACCURACY, false, lvl);
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

    public Map<Double, Double> getCanonicalResTable() {
        return canonicalResTable;
    }

    public void setCanonicalResTable(Map<Double, Double> canonicalResTable) {
        this.canonicalResTable = canonicalResTable;
    }

    public abstract double calc(double arg);
}

