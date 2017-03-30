import function.trigonometric.Tan;
import util.Writer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;

/**
 * Created by cezar on 3/29/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Math.cos(Double.POSITIVE_INFINITY));
        //Writer.generateCanonicalCSVFiles(-Math.PI, Math.PI, .0, 12.0, 1e-5);
        //Writer.generateCanonicalCSVFiles(-2.1 * Math.PI, 0.1, 0, 3, 1e-6);
        //Writer.generateCanonicalCSVFiles(-2 * Math.PI, 2 * Math.PI, 0, 3, 1e-5);
        //Writer.generateCanonicalCSVFiles(-2 * Math.PI - 0.01, 2 * Math.PI + 0.01, 0, 12, 1e-5); //last

        //for(double curr = -2 * Math.PI - 0.01; curr < 2 * Math.PI + 0.01; curr += 1e-5)
          //  if (curr > 1.57 && curr < 1.58)
           // System.out.println(String.format("%f%f\n", curr, Math.cos(curr)));

        List<Double[]> data = new ArrayList<>();
        for (double acc = 1e-6;acc > 1e-6; acc *= 1e-1) {
            for (double x = (PI/2)-0.001; x < (PI/2)+0.001; x += 0.001) {
                data.add(new Double[] { x, acc, new Tan(acc, true).calc(x) });
            }
        }
    }
}