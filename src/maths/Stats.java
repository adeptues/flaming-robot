/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

/**
 * This class contains some static functions that are statistical operators 
 * that can be performed upon data sets 
 * @author adeptues
 */
public class Stats {
    
    /**
     * Finds the average value of a data set
     * @param data
     * @return 
     */
    public static double average(double [] data){
        double total = 0;
        for(int i = 0; i < data.length; i++){
            total = data[i]+total;
        }
        double avg = total/data.length;
        return avg;
    }
    
    /**
     * Computes the standard deviation of a data set using the sample
     * distribution
     * @param data
     * @return 
     */
    public static double standardDeviation(double [] data){
        double avg = Stats.average(data);
        double sum = 0.0;
        for(int i = 0; i < data.length; i++){
            sum += Math.pow((data[i]-avg),2);
        }
        //sample population
        double stdev = Math.pow((sum/(data.length-1)),0.5);
        return stdev;
    }
    
    /**
     * Calculates the variance of a dataset
     * @param data
     * @return 
     */
    public static double variance(double [] data){
        double avg = Stats.average(data);
        double sum = 0.0;
        for(int i = 0; i < data.length; i++){
            sum += Math.pow((data[i]-avg),2);
        }
        double variance = (sum/(data.length-1));
        return variance;
    }
    
    /**
     * Calculates the covaraince of the x and y values where the length of 
     * these values is the same. returns -1 if not the same
     * 
     * This uses n instead of n-1 this is bias corrected 
     * @param x
     * @param y
     * @return 
     */
    public static double coVariance(double [] x, double [] y){
        double ex = Stats.average(x);//mean of x values
        double ey = Stats.average(y);//mean of y values
        double sum = 0.0;
        if(x.length == y.length){
            for(int i = 0; i < x.length; i++){
                double xdiff = x[i]-ex;
                double ydiff = y[i]-ey;
                sum+= (xdiff*ydiff);
            }
            double rtn = sum/x.length;
            return rtn;
        }
        return -1;
    }
    
    //TODO addcovariance matrix 
    
}
