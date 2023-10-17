package com.teoriacomputacion.helpers;

import java.awt.*;

import javax.swing.JPanel;

public class DrawDiagram extends JPanel {
  private boolean isActiveReadyOval;
  private boolean isActiveSendingOval;
  private boolean isActiveq0;
  private boolean isActiveq1;
  private boolean isActiveq2;
  private boolean isActiveq3;

  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setFont(new Font("Serif", Font.PLAIN, 12));
    this.paintSendingOval(g2);
    this.paintReadyOval(g2);
    this.paintq0Oval(g2);
    this.paintq1Oval(g2);
    this.paintq2Oval(g2);
    this.paintq3Oval(g2);
    this.paintLines(g2);
  }

  private void paintReadyOval(Graphics2D g2) {

    g2.drawString("Ready", getWidth() / 2 - 300, 200);
    if (this.isActiveReadyOval) {
      this.setColorToRed(g2);
      g2.fillOval(getWidth() / 2 - 300, 200, 100, 100);
      this.resetColorToBlack(g2);
      return;
    }

    g2.drawOval(getWidth() / 2 - 300, 200, 100, 100);
    this.resetColorToBlack(g2);
  }

  private void paintSendingOval(Graphics2D g2) {
    g2.drawString("Sending", getWidth() / 2 + 200, 200);
    if (this.isActiveSendingOval) {
      this.setColorToRed(g2);
      g2.fillOval(getWidth() / 2 + 200, 200, 100, 100);
      this.resetColorToBlack(g2);
      return;
    }

    g2.drawOval(getWidth() / 2 + 200, 200, 100, 100);
  }

  private void paintq0Oval(Graphics2D g2) {
    g2.drawString("q0", getWidth() / 2 - 180, 350);

    if (this.isActiveq0) {
      this.setColorToRed(g2);
      g2.fillOval(getWidth() / 2 - 180, 350, 100, 100);
      g2.fillOval(getWidth() / 2 - 175, 355, 90, 90);
      this.resetColorToBlack(g2);
      return;
    }

    g2.drawOval(getWidth() / 2 - 180, 350, 100, 100);
    g2.drawOval(getWidth() / 2 - 175, 355, 90, 90);
  }

  private void paintq1Oval(Graphics2D g2) {
    g2.drawString("q1", getWidth() / 2 + 180, 350);
    if (this.isActiveq1) {
      this.setColorToRed(g2);
      g2.fillOval(getWidth() / 2 + 100, 350, 100, 100);
      this.resetColorToBlack(g2);
      return;
    }

    g2.drawOval(getWidth() / 2 + 100, 350, 100, 100);
    g2.drawString("q1", getWidth() / 2 + 180, 350);
  }

  private void paintq2Oval(Graphics2D g2) {
    g2.drawString("q2", getWidth() / 2 - 180, 550);
    if (this.isActiveq2) {
      this.setColorToRed(g2);
      g2.fillOval(getWidth() / 2 - 180, 550, 100, 100);
      this.resetColorToBlack(g2);
      return;
    }

    g2.drawOval(getWidth() / 2 - 180, 550, 100, 100);
  }

  private void paintq3Oval(Graphics2D g2) {
    g2.drawString("q3", getWidth() / 2 + 180, 550);

    if (this.isActiveq3) {
      this.setColorToRed(g2);
      g2.fillOval(getWidth() / 2 + 100, 550, 100, 100);
      this.resetColorToBlack(g2);
      return;
    }

    g2.drawOval(getWidth() / 2 + 100, 550, 100, 100);
  }

  private void paintLines(Graphics2D g2) {
    g2.drawLine(getWidth() / 2 - 200, 235, getWidth() / 2 + 200, 235);
    g2.setColor(Color.BLUE);
    g2.fillOval(getWidth() / 2 + 195, 230, 10, 10);
    g2.setColor(Color.BLACK);
    g2.drawLine(getWidth() / 2 - 200, 260, getWidth() / 2 + 200, 260);
    g2.setColor(Color.BLUE);
    g2.fillOval(getWidth() / 2 - 205, 256, 10, 10);
    g2.setColor(Color.BLACK);

    // Parity
    // q0 - q1
    g2.drawLine(getWidth() / 2 - 80, 395, getWidth() / 2 + 100, 395);
    g2.drawLine(getWidth() / 2 - 80, 405, getWidth() / 2 + 100, 405);

    // q1 - q3
    g2.drawLine(getWidth() / 2 + 145, 449, getWidth() / 2 + 145, 550);
    g2.drawLine(getWidth() / 2 + 155, 449, getWidth() / 2 + 155, 550);

    // q3 - q2
    g2.drawLine(getWidth() / 2 - 80, 590, getWidth() / 2 + 100, 590);
    g2.drawLine(getWidth() / 2 - 80, 600, getWidth() / 2 + 100, 600);
    // q0

    g2.drawLine(getWidth() / 2 - 135, 449, getWidth() / 2 - 135, 550);
    g2.drawLine(getWidth() / 2 - 125, 449, getWidth() / 2 - 125, 550);
  }

  private void resetColorToBlack(Graphics2D g2) {
    g2.setColor(Color.black);
  }

  private void setColorToRed(Graphics2D g2) {
    g2.setColor(Color.RED);
  }

  public void cleanParityOvals(boolean pause) {
    this.isActiveq0 = false; 
    this.isActiveq1 = false; 
    this.isActiveq2 = false; 
    this.isActiveq3 = false; 
    repaint();
    if(pause) this.pause();

  }

  public void cleanAll() {
    this.isActiveq0 = false; 
    this.isActiveq1 = false; 
    this.isActiveq2 = false; 
    this.isActiveq3 = false; 
    this.isActiveReadyOval = false;
    this.isActiveSendingOval = false;
    repaint();
    this.pause();
  }

  public void setActiveReadyOval(boolean isActiveReadyOval, boolean pause) {
    this.isActiveReadyOval = isActiveReadyOval;
    repaint();
    if(pause) this.pause();

  }

  public void setActiveSendingOval(boolean isActiveSendingOval, boolean pause) {
    this.isActiveSendingOval = isActiveSendingOval;
    repaint();
    if(pause) this.pause();

  }

  public void setActiveq0(boolean isActiveq0, boolean pause) {
    this.isActiveq0 = isActiveq0;
    repaint();
    if(pause) this.pause();
  }

  public void setActiveq1(boolean isActiveq1, boolean pause) {
    this.isActiveq1 = isActiveq1;
    repaint();
    if(pause) this.pause();

  }

  public void setActiveq2(boolean isActiveq2, boolean pause) {
    this.isActiveq2 = isActiveq2;
    repaint();
    if(pause) this.pause();
  }

  public void setActiveq3(boolean isActiveq3, boolean pause) {
    this.isActiveq3 = isActiveq3;
    repaint();
    if(pause) this.pause();

  }

  private void pause() {
    try {
      Thread.sleep(750);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
