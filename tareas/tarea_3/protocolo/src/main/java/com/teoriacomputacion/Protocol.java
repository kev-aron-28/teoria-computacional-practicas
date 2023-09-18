package com.teoriacomputacion;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.teoriacomputacion.helpers.FileHelper;
import com.teoriacomputacion.helpers.RandomBinary;

public class Protocol {

  private FileHelper evenBinaryFile;
  private FileHelper oddBinaryFile;

  public Protocol() {
    this.evenBinaryFile = new FileHelper("evenBinary.txt");
    this.oddBinaryFile = new FileHelper("oddBinary.txt");
  }

  public void startProtocol() throws InterruptedException {
    boolean protocolIsOn = true; 

    while(protocolIsOn) {
      ArrayList<String> binaryList = ready();
      send(binaryList);
      protocolIsOn = this.randomSwitch();
    }
    System.out.println("Turning down machine");
  }

  private ArrayList<String> ready() {
    ArrayList<String> s = new ArrayList<>(10000);
    System.out.println("Generating data");
    for (int i = 0; i < 10000; i++) {
      String binaryString = RandomBinary.generateBinaryString(64);
      s.add(binaryString);
    }
    return s;
  }

  private void send(ArrayList<String> data) throws InterruptedException {
    boolean simulateTimeout = randomSwitch();
    while(simulateTimeout) {
      System.out.println("Timeout, trying again");
      TimeUnit.SECONDS.sleep(3);
      simulateTimeout = randomSwitch();
    }

    for (String s : data) {
      boolean isEven = ParityBinary.checkBinaryString(s);
      if(isEven) evenBinaryFile.writeToFile(s);
      else oddBinaryFile.writeToFile(s);
    }
  }

  private boolean randomSwitch() {
    Random r = new Random();
    int randomInt = r.nextInt(100) + 1;

    if(randomInt > 50) return true;
    else return false;
  }

}
