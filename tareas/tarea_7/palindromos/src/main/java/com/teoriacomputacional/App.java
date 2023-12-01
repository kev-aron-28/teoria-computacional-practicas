package com.teoriacomputacional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class App {

  public static String RandomInitialDerivation() {
    Random rand = new Random();
    int n = rand.nextInt(2);
    String result;
    switch (n) {
      case 0:
        result = "0P0";
        break;
      default:
        result = "1P1";
        break;
    }

    return result;
  }

  public static String RandomFinalDerivation() {
    Random rand = new Random();
    int n = rand.nextInt(3);
    String result;
    switch (n) {
      case 0:
        result = "0";
        break;
      case 1:
        result = "";
      default:
        result = "1";
        break;
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    int counter;
    String test = RandomInitialDerivation();
    File file = new File("logs.txt");
    FileWriter fr = new FileWriter(file, true); // parameter 'true' is for append mode
    PrintWriter printWriter = new PrintWriter(fr);
    printWriter.print("");
    printWriter.println(test);

    String sub;

    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter a number: ");
    int userNumber = scanner.nextInt();
    scanner.close();
    for (counter = 0; counter < userNumber; counter++) {
      int lastIndexOfP = test.indexOf("P");
      sub = test.substring(0, lastIndexOfP) + RandomInitialDerivation() + test.substring(lastIndexOfP + 1);
      if (counter == (userNumber - 1)) {
        sub = test.substring(0, lastIndexOfP) + RandomFinalDerivation() + test.substring(lastIndexOfP + 1);
      }
      test = sub;
      printWriter.println(test);
    }
    printWriter.close();
  }
}
