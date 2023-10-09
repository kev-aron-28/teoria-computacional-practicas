package com.teoriacomputacion.services;
import java.io.FileNotFoundException;

import org.jfree.data.category.DefaultCategoryDataset;

public class PowersService {
    private String[] alphabet = { "0", "1" };
    private FileService fileService;
    private ChartService chartService;
    private DefaultCategoryDataset data = new DefaultCategoryDataset();

    public PowersService() {
        this.fileService = new FileService("output.txt");
        this.chartService = new ChartService();
        this.fileService.writeToFile("E = {");
        this.fileService.writeToFile("e,");
    }

    public DefaultCategoryDataset getDataForChart() {
        return this.data;
    } 

    public void calculatePowersFromAlphabet (int power, int startIndex, String currentCombination[]) throws FileNotFoundException { 
        
        if(power == 0) {
            String toWrite = String.join("", currentCombination);
            data.addValue(this.countOnesFromString(toWrite), "numero de 1's", toWrite);
            fileService.writeToFile(toWrite + ",");
            return;
        }

        for (int current = 0; current < alphabet.length; current++) {
            currentCombination[currentCombination.length - power] = alphabet[current];
            calculatePowersFromAlphabet(power - 1, startIndex+1, currentCombination);
        }
    }


    public void createChart() throws FileNotFoundException {
        this.fileService.writeToFile("}");
        this.chartService.createChart(this.data);
    }

    public int countOnesFromString(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' ) {
                count++;
            }
        }

        return count;
    }

}
