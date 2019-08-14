package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessWithACounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomNum = new Random();
        int n = randomNum.nextInt(10)+1;
        int guessCounter = 1;


        System.out.println("I'm thinking of a number from 1 to 10");
        System.out.println("Your guess: ");
        int guess = Integer.parseInt(scan.nextLine());

        while (n != guess) {

            System.out.println("That is incorrect. Guess again.");
            guess = Integer.parseInt(scan.nextLine());
            guessCounter++;
        }
        System.out.println("That's right! You're a good guesser!");
        System.out.println("It only took you " + guessCounter + " tries.");
    }
}
