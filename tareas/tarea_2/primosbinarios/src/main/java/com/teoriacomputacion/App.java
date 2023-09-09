package com.teoriacomputacion;

import java.io.FileNotFoundException;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        Menu menu = new Menu(new PrimeBinary());
        menu.start();
        System.out.println("Program is over");
    }
}
