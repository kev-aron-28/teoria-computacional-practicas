package com.teoriacomputacion;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        try {
            new Search().read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
