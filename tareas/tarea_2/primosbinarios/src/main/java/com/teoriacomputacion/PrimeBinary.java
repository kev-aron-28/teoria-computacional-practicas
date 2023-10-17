package com.teoriacomputacion;

import java.io.FileNotFoundException;
import org.jfree.data.category.DefaultCategoryDataset;

public class PrimeBinary {
    private ChartHelper chartHelper;
    private FileHelper binaryFile;
    private FileHelper decimalFile;

    public PrimeBinary() {
        this.chartHelper = new ChartHelper();
        this.binaryFile = new FileHelper("outputBinary.txt");
        this.decimalFile = new FileHelper("outputDecimal.txt");
        this.binaryFile.writeToFile("E={", false);
        this.decimalFile.writeToFile("E={", false);
    }

    public void calculatePrimes (double n) throws FileNotFoundException {
        DefaultCategoryDataset dataForChart = new DefaultCategoryDataset();

        for (int counter = 2; counter <= n; counter++) {
            if(isPrime(counter)) {
                String binary = Integer.toBinaryString(counter);
                dataForChart.addValue(
                    countOnesFromString(binary), 
                    "numero de 1's", 
                    binary
                );
                this.binaryFile.writeToFile(binary, true);
                this.decimalFile.writeToFile(counter + "", true);
            }
        }
        this.binaryFile.writeToFile("}", false);
        this.decimalFile.writeToFile("}", false);
        this.chartHelper.createChart(dataForChart);
    }

    private boolean isPrime (double n) {
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
}
