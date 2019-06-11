package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomNum = new Random();
        int n = randomNum.nextInt(10)+1;

        System.out.println("I'm thinking of a number from 1 to 10");
        System.out.println("Your guess: ");
        int guess = Integer.parseInt(scan.nextLine());

        if(n != guess) {
            System.out.println("Sorry, I was really thinking of " + n + ".");
        } else {
            System.out.println("That's right! My secret number was " + n + "!");
        }

    }
}
