package util;

import function.AbstractFunction;
import system.System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cezar on 3/26/17.
 */
public class Writer {
    private static String SEPARATOR = ";";
    private AbstractFunction function;
    private static Map<String, HashMap<Double, Double>> resultCache = new HashMap<>();

    public void toCSVFile(double from, double to, double step) {
        if (to < from) {
            throw new IllegalArgumentException("to < from");
        }

        try {
            FileWriter fileWriter = new FileWriter(this.getClass().getSimpleName() + "-gen.csv", false);

            for(double curr = from; curr < to; curr += step) {
                double res = function.calc(curr);

                if(res == Double.NEGATIVE_INFINITY || res == Double.POSITIVE_INFINITY || res == Double.NaN)
                    continue;

                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, res));
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Double, Double> parseCanonicalCSVFile() {
        String name = "./canonical/" + this.getClass().getSimpleName() + "-canonical.csv",
                line;

        if(resultCache.get(this.getClass().getName()) != null)
            return resultCache.get(this.getClass().getName());

        HashMap<Double, Double> result = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(name));

            while ((line = br.readLine()) != null) {

                String[] canonicalResult = line.split(SEPARATOR);

                result.put(Double.parseDouble(canonicalResult[0].replace(',', '.')),
                        Double.parseDouble(canonicalResult[1].replace(',', '.')));

            }

            br.close();

            resultCache.put(this.getClass().getName(), result);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultCache.get(this.getClass().getName());
    }
    public static void generateCanonicalCSVFiles(double tFrom, double tTo, double lFrom, double lTo,  double tStep) {
        double curr;

        try {
            FileWriter fileWriter = new FileWriter("./canonical/Sin-canonical.csv", false);

            for(curr = tFrom; curr < tTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, Math.sin(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Cos-canonical.csv", false);

            for(curr = tFrom; curr < tTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, Math.cos(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Cot-canonical.csv", false);

            for(curr = tFrom; curr < tTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, 1.0 / Math.tan(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Tan-canonical.csv", false);

            for(curr = tFrom; curr < tTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, Math.tan(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Csc-canonical.csv", false);

            for(curr = tFrom; curr < tTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, 1.0 / Math.sin(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Sec-canonical.csv", false);

            for(curr = tFrom; curr < tTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, 1.0 / Math.cos(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Ln-canonical.csv", false);

            for(curr = lFrom; curr < lTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, Math.log(curr)));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Log3-canonical.csv", false);

            for(curr = lFrom; curr < lTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, (Math.log(curr)/Math.log(3))));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Log2-canonical.csv", false);

            for(curr = lFrom; curr < lTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, (Math.log(curr)/Math.log(2))));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Log5-canonical.csv", false);

            for(curr = lFrom; curr < lTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, (Math.log(curr)/Math.log(5))));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Log10-canonical.csv", false);

            for(curr = lFrom; curr < lTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, (Math.log(curr)/Math.log(10))));

            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("./canonical/Writer-canonical.csv", false);

            for(curr = lFrom; curr < lTo; curr += tStep)
                fileWriter.append(String.format("%f%s%f\n", curr, SEPARATOR, new System(0).calc(curr)));

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSEPARATOR() {
        return SEPARATOR;
    }

    public static void setSEPARATOR(String SEPARATOR) {
        Writer.SEPARATOR = SEPARATOR;
    }

    public AbstractFunction getFunction() {
        return function;
    }

    public void setFunction(AbstractFunction function) {
        this.function = function;
    }
}
