package com.teoriacomputacion.services;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    
    private String fileName;
    private File file;
    public FileService(String fileName) {
        this.deleteFile(fileName);
        this.file = this.createFile(fileName);
        this.fileName = fileName;
    }

    public void writeToFile(String text){
        try {
            FileWriter fileWriter = new FileWriter(this.fileName, true);
            fileWriter.write(text + "\n");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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
