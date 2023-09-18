package com.teoriacomputacion.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileHelper {
    
    private String fileName;
    private File file;
    
    public FileHelper(String fileName) {
        this.deleteFile(fileName);
        this.file = this.createFile(fileName);
        this.fileName = fileName;
    }

    public void writeToFile(String text){
        try {
            FileWriter fileWriter = new FileWriter(this.fileName, true);
            fileWriter.write(text + ",");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public Map<String, Integer> readFile() throws FileNotFoundException {
        File file = new File(this.fileName);
        Scanner sc = new Scanner(file);

        Map<String, Integer> map = new LinkedHashMap<>();
        sc.useDelimiter("\n");
     
        while (sc.hasNextLine()){
            String c = sc.nextLine();
            String[] comb = c.split(" ");
            map.put(comb[0], Integer.parseInt(comb[1]));
        }

        sc.close();
        return map;
    }

    private void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }

    private File createFile(String fileName) {
        try {
            File file = new File(fileName);
            file.createNewFile();
        } catch (IOException  e) {
            System.out.println("Something happened");
            e.printStackTrace();
        }

        return file;
    }
}
