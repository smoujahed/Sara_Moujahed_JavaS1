package com.company;

import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {

        Random random = new Random();
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;

        do {
            roll1 = random.nextInt(6) + 1;
            roll2 = random.nextInt(6) + 1;

            System.out.println("HERE COMES THE DICE!");

            System.out.println("Roll #1: " + roll1);
            System.out.println("Roll #2: " + roll2);

            int sum = roll1 + roll2;

            System.out.println("The total is " + sum + "!");
        } while (roll1 != roll2);
    }

}

