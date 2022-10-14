package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Main {
    public static void main(String[] args) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.addValue(1.0);
        stats.addValue(2.0);
        stats.addValue(3.0);
        stats.addValue(4.0);
        System.out.println("Mean: " + stats.getMean());
        System.out.println("Standard Deviation: " + stats.getStandardDeviation());
        System.out.println("Variance: " + stats.getVariance());
    }
}