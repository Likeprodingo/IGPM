package by.shibaev.igpm.laba1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IterationMethod {
    public double[] calculate(double[][] a, double[] d, double e) {
        double[] x = new double[d.length];
        double[] x0 = new double[]{0, 0, 0, 0, 0};
        double max;
        int iteration = 0;
        do {
            iteration++;
            for (int i = 0; i < a.length; i++) {
                x[i] = d[i];
                for (int j = 0; j < i; j++) {
                    x[i] -= a[i][j] * x0[j];
                }
                for (int j = i + 1; j < a[i].length; j++) {
                    x[i] -= a[i][j] * x0[j];
                }
                x[i] /= a[i][i];
            }
            max = Math.abs(x[0] - x0[0]);
            for (int i = 1; i < x.length; i++) {
                double temp = Math.abs(x[i] - x0[i]);
                if (temp > max) {
                    max = temp;
                }
            }
            for (int i = 0; i < x.length; i++) {
                x0[i] = x[i];
            }
        } while (!(max < e));
        System.out.println(iteration);
        return x;
    }
}
