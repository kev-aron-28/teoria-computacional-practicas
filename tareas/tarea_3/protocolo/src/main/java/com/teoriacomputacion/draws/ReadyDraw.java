package com.teoriacomputacion.draws;
import java.awt.*;  

public class ReadyDraw extends Component {    
  
   // initializing using constructor  
   public void paint(Graphics g) {  
    Graphics2D g2 = (Graphics2D) g;
    g2.drawOval(getWidth()/2 - 200, getHeight()/2 - 100, 50, 50);
    g2.setFont(new Font("Serif", Font.PLAIN, 12));
    g2.drawString("Ready", getWidth()/2 - 201, getHeight()/2 - 100); 
  }  

}    
