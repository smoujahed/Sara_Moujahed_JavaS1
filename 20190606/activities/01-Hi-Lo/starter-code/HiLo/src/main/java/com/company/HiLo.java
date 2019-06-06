package com.company;

import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfGuess = 1;
        int randomNum = (int) (Math.random()*101);

        //prompt user for their name and collect input
        System.out.println("Welcome to Hi-Low!");
        System.out.println("Please enter your name");
        String name = input.nextLine();

        //display rules
        System.out.println("OK, " + name + ", here are the rules:");
        System.out.println("1. The computer will come up with a number between 1 and 100 (inclusive).");
        System.out.println("2. The user will be prompted to guess the number.");
        System.out.println("3. If the user guesses the number correctly, the program displays:");
        System.out.println("        1. Congratulations " + name + "! You Win!");
        System.out.println("        2. It took you _____ guesses to find my number");
        System.out.println("4. If the user does not guess the number correctly, the program will display “Too low!” if the " +
                "guess is too low and “Too high!” if the guess is too high, and then will prompt the user for another guess.  " +
                "This goes on until the number is guessed correctly.");
        //start game
        System.out.println("Please guess a number");
        int userGuess = Integer.parseInt(input.nextLine());

        while (userGuess != randomNum) {
            if (userGuess < randomNum) {
                numOfGuess++;
                System.out.println("Too low! Keep trying...");
                userGuess = Integer.parseInt(input.nextLine());
            } else {
                numOfGuess++;
                System.out.println("Too high! Keep trying...");
                userGuess = Integer.parseInt(input.nextLine());
            }
        }

        if (userGuess == randomNum) {
            System.out.println("Congratulations, " + name + "! You win!");
            System.out.println("It took you " + numOfGuess + " guesses to find my number!");
        }

//
//        while (userGuess > randomNum) {
//            numOfGuess++;
//            System.out.println("Too high!");
//            System.out.println("Keep trying...");
//            userGuess = Integer.parseInt(input.nextLine());
//        }
//
//        while (userGuess < randomNum) {
//            numOfGuess++;
//            System.out.println("Too Low!");
//            System.out.println("Keep trying...");
//        }
//
//        while (userGuess == randomNum){
//            System.out.println("Congratulations " + name + "! You win!");
//            System.out.println("It took you " + numOfGuess + " guesses to find my number!");
//        }

    }
}
