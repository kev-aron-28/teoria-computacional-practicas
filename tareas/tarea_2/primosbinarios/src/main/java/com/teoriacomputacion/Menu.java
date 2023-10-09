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
        int isOn = 1;
        while(isOn != 0) {
            if (this.askIfRandom() == 1) {
                System.out.println("N: ");
                this.n = this.generateRandom();
            } else {
                this.n = this.askN();
            }
            this.primeBinary.calculatePrimes(this.n);
            isOn = this.askIfContinue();
        }
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

    public int askIfContinue() {
        System.out.println("Want to continue(1: Y, 0: N): ");
        int n = scanner.nextInt();
        return n;
    }

    public int generateRandom() {
        Random r = new Random();
        int randomInt = r.nextInt(10000) + 1;
        return randomInt;
    }
}
