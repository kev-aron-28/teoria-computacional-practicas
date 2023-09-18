package com.teoriacomputacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import com.teoriacomputacion.draws.ReadyDraw;
import com.teoriacomputacion.draws.SendingDraw;

import javafx.scene.canvas.Canvas;

public class App {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My first JFrame");
        Canvas canvas = new Canvas();
        canvas.add
        frame.getContentPane().add(new SendingDraw());
        frame.setVisible(true);
        frame.setSize(300, 300);
    }
}
