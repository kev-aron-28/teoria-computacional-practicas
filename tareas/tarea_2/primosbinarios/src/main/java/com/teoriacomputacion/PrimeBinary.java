package com.teoriacomputacion;

import java.io.FileNotFoundException;
import java.util.Map;

public class PrimeBinary {
    private FileHelper fileHelper;
    private ChartHelper chartHelper;

    public PrimeBinary() {
        this.fileHelper = new FileHelper("output.txt");
        this.chartHelper = new ChartHelper();
    }

    public void calculatePrimes (double n) throws FileNotFoundException { 
        for (int counter = 2; counter <= n; counter++) {
            if(isPrime(counter)) {
                System.out.println(counter);
                String binary = Integer.toBinaryString(counter);
                this.fileHelper.writeToFile( binary + " " + this.countOnesFromString(binary));
            }
        }
    }

    private boolean isPrime(double n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }

        return true;
    } 

    private int countOnesFromString(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' ) {
                count++;
            }
        }

        return count;
    }

    public void createChart() throws FileNotFoundException {
        Map<String, Integer> data = this.fileHelper.readFile();
        this.chartHelper.createChart(data);
    }

}
