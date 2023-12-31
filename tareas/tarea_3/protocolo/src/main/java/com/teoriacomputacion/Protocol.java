package com.teoriacomputacion;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.teoriacomputacion.helpers.DrawDiagram;
import com.teoriacomputacion.helpers.FileHelper;
import com.teoriacomputacion.helpers.RandomBinary;

public class Protocol {

  private FileHelper evenBinaryFile;
  private FileHelper oddBinaryFile;
  private JFrame frame;
  private DrawDiagram diagram;

  public Protocol() {
    this.evenBinaryFile = new FileHelper("evenBinary.txt");
    this.oddBinaryFile = new FileHelper("oddBinary.txt");
    this.frame = new JFrame("Protocol");
    this.frame.setVisible(true);
    this.frame.setSize(300,300);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

    this.diagram = new DrawDiagram();

    this.frame.add(diagram);
  }

  public void startProtocol() throws InterruptedException {
    boolean protocolIsOn = true; 

    while(protocolIsOn) {
      ArrayList<String> binaryList = ready();
      send(binaryList);
      protocolIsOn = this.randomSwitch();
    }

    this.frame.dispose();
    System.out.println("Turning down machine");
  }

  private ArrayList<String> ready() {
    ArrayList<String> s = new ArrayList<>(8);
    System.out.println("Generating data");
    this.diagram.setActiveReadyOval(true, true);
    this.diagram.setActiveSendingOval(false, false);
    for (int i = 0; i < 8; i++) {
      String binaryString = RandomBinary.generateBinaryString(6);
      s.add(binaryString);
    }
    return s;
  }

  private void send(ArrayList<String> data) throws InterruptedException {
    boolean simulateTimeout = randomSwitch();
    this.diagram.setActiveReadyOval(false, false);
    this.diagram.setActiveSendingOval(true, true);
    while(simulateTimeout) {
      System.out.println("Timeout, trying again");
      TimeUnit.SECONDS.sleep(3);
      simulateTimeout = randomSwitch();
    }

    for (String s : data) {
      boolean isEven = ParityBinary.checkBinaryString(s, diagram);
      this.diagram.cleanParityOvals(true);

      if(isEven) evenBinaryFile.writeToFile(s);
      else oddBinaryFile.writeToFile(s);
    }

    this.diagram.cleanParityOvals(true);
    this.diagram.setActiveSendingOval(false, false);
  }


  private boolean randomSwitch() {
    Random r = new Random();
    int randomInt = r.nextInt(100) + 1;

    if(randomInt > 50) return true;
    else return false;
  }

}
