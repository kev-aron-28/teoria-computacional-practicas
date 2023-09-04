package com.teoriacomputacion.services;

import java.io.FileNotFoundException;
import java.util.Map;

public class PowersService {
    private String[] alphabet = { "0", "1" };
    private FileService fileService;
    private ChartService chartService;

    public PowersService() {
        this.fileService = new FileService("output.txt");
        this.chartService = new ChartService();
        this.fileService.writeToFile("E 0");
    }

    public void calculatePowersFromAlphabet (int power, int startIndex, String currentCombination[]) throws FileNotFoundException { 
        if(power == 0) {
            String toWrite = String.join("", currentCombination);
            int totalOnes = this.countOnesFromString(toWrite);
            fileService.writeToFile(toWrite + " " + totalOnes);
            return;
        }
        
        for (int current = 0; current < alphabet.length; current++) {
            currentCombination[currentCombination.length - power] = alphabet[current];
            calculatePowersFromAlphabet(power - 1, startIndex+1, currentCombination);
        }
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
        Map<String, Integer> data = this.fileService.readFile();
        this.chartService.createChart(data);
    }

}
