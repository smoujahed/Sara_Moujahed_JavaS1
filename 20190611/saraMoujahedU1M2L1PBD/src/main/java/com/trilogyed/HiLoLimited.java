package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HiLoLimited {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomNum = new Random();
        int n = randomNum.nextInt(100) + 1;


        System.out.println("I'm thinking of a number from 1 to 100. You have 7 guesses.");
        System.out.println("First guess: ");
        int guess = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= 7; i++) {
            if (n == guess) {
                System.out.println("You guessed it! What are the odds?!?");
                break;
            } else if (n > guess) {
                System.out.println("Sorry, you are too low.");
                System.out.println("Guess #" + (i+2) + ":");
                guess = Integer.parseInt(scan.nextLine());
            } else {
                System.out.println("Sorry, you are too high.");
                System.out.println("Guess #" + (i+2) + ":");
                guess = Integer.parseInt(scan.nextLine());
            }


        }
    }
}
