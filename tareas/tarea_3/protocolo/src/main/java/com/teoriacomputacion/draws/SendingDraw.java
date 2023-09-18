package com.teoriacomputacion.draws;

import java.awt.*;  
public class SendingDraw extends Component {    
  
   // initializing using constructor  
   public void paint(Graphics g) {  
    Graphics2D g2 = (Graphics2D) g;
    g2.drawOval(getWidth()/2 - 300, getHeight()/2 - 200, 100, 100);
    g2.drawString("Ready", getWidth()/2 - 300, getHeight()/2 - 200);
    
  }  

}    
