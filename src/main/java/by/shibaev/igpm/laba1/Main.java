package by.shibaev.igpm.laba1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        double[][] a = new double[][]{
                {-3.17, 1, 0, 0, 0},
                {1, -2, 1, 0, 0},
                {0, 1, -2, 1, 0},
                {0, 0, 1, -2, 1},
                {0, 0, 0, 1, -3.17}
        };
        double[] d = new double[]{0, 1, 1, 1, 0};
        double e = 0.001;
        double[] x = new IterationMethod().calculate(a, d, e);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
}
