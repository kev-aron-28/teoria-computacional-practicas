package com.teoriacomputacion;

import java.io.FileNotFoundException;

import com.teoriacomputacion.services.MenuService;
import com.teoriacomputacion.services.PowersService;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException{
        MenuService menu = new MenuService(new PowersService());
        menu.start();
        System.out.println("El programa ha finalizado");
    }
    
}
