package com.teoriacomputacion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
    
    private String fileName;
    private File file;
    
    public FileHelper(String fileName) {
        this.deleteFile(fileName);
        this.file = this.createFile(fileName);
        this.fileName = fileName;
    }

    public void writeToFile(String text, boolean withComma){
        try {
            FileWriter fileWriter = new FileWriter(this.fileName, true);
            if(text == "E={") fileWriter.write(text);
            else {
                if(withComma) {
                    fileWriter.write(text + ",");
                } else {
                    fileWriter.write(text);
                }
            }
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
