package com.teoriacomputacion.services;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MenuService {

    Scanner scanner = new Scanner(System.in);
    int power;

    PowersService powersService;
    public MenuService(PowersService powersService) {
        this.powersService = powersService;
    }

    public void start() throws FileNotFoundException {
        if(this.askIfRandom() == 1) {
            this.power = this.generateRandom();
        } else {
            this.power = this.askN();
        }

        this.loopToLimit();
        this.powersService.createChart();
    }

    private void loopToLimit() throws FileNotFoundException {
        for (int i = 1; i <= this.power; i++) {
            this.powersService.calculatePowersFromAlphabet(i, 0, new String[i]);
        }

    }

    public int askN() {
        System.out.println("Type the quantity of powers ");
        int n = scanner.nextInt();
        return n;
    }

    public int askIfRandom() {
        System.out.println("Want a random number?: ");
        int n = scanner.nextInt();
        return n;
    }

    public int generateRandom() {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;

        return randomInt;
    }
}
