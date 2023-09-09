package com.teoriacomputacion;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    double n;

    PrimeBinary primeBinary;
    public Menu(PrimeBinary primeBinary) {
        this.primeBinary = primeBinary;
    }

    public void start() throws FileNotFoundException {
        if(this.askIfRandom() == 1) {
            this.n = this.generateRandom();
        } else {
            this.n = this.askN();
        }

        this.primeBinary.calculatePrimes(n);

        this.primeBinary.createChart();
    }

    public double askN() {
        System.out.println("Type the n: ");
        double n = scanner.nextDouble();
        return n;
    }

    public int askIfRandom() {
        System.out.println("Want a random number (1: Y, 0: N)?: ");
        int n = scanner.nextInt();
        return n;
    }

    public int generateRandom() {
        Random r = new Random();
        int randomInt = r.nextInt(10) + 1;
        System.out.println(randomInt);

        return randomInt;
    }
}
