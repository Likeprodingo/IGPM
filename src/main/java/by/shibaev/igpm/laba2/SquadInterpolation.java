package by.shibaev.igpm.laba2;

import by.shibaev.igpm.laba1.IterationMethod;

public class SquadInterpolation {
    public void squadInterpolation(int a, int b, int m) {

        double [] xVec = new double[m];
        double [] yVec = new double[m];

        double xt = a + (double)(-1 * (b-a)) / (m-1);
        double yt =  Math.pow(xt,3) - 50 * Math.cos(xt);

        for (int i = 1; i < m; i++) {
            xVec[i] = a + (double)((i-1) * (b-a)) / (m-1);
            yVec[i] = Math.pow(xVec[i],3) - 50 * Math.cos(xVec[i]);
            if(xVec[i] < xt){
                xt = xVec[i];
                yt = yVec[i];
            }
        }

        //print xVec and yVec graph

        double [][] matrix = {
                {Math.pow(xVec[0],2),xVec[0],1},
                {Math.pow(xVec[10],2),xVec[10],1},
                {Math.pow(xt,2),xt,1}
        };

        double [] vec = {yVec[0],yVec[10], yt};

        double [] result = new IterationMethod().calculate(matrix,vec, 0.001);

        double []x = new double[b-a];
        double []y = new double[b-a];
        for (int i = a; i <= b; i++) {
            y[i] = result[0] * i * i + result[1] * i + result[2];
            x[i] = i;
        }

        //print x and y graph
    }
}
