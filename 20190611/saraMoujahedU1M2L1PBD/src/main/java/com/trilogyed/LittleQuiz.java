package com.trilogyed;

import java.util.Scanner;

public class LittleQuiz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRight = 0;

        System.out.println("Are you ready for a quiz?");
        System.out.println("Okay here it comes!");
        System.out.println("");

        //question 1
        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("        1) Melbourne");
        System.out.println("        2) Anchorage");
        System.out.println("        3) Juneau");

        int answer1 = Integer.parseInt(scan.nextLine());

        if (answer1 == 1 || answer1 == 2) {
            System.out.println("Sorry, the capital of Alaska is Juneau");
        } else if (answer1 == 3){
            System.out.println("That's right!");
            numRight++;
        } else {
            System.out.println("You entered an invalid option");
        }

        //question 2
        System.out.println("Q2) Can you store the value 'cat' in a variable of type int?");
        System.out.println("        1) yes");
        System.out.println("        2) no");
        int answer2 = Integer.parseInt(scan.nextLine());

        if (answer2 == 1) {
            System.out.println("Sorry, 'cat' is a string. Ints can only store numbers.");
        } else if (answer2 == 2) {
            System.out.println("That's right!");
        } else {
            System.out.println("You entered an invalid option");
        }


        //question 3
        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("        1) 5");
        System.out.println("        2) 11");
        System.out.println("        3) 15/3");
        int answer3 = Integer.parseInt(scan.nextLine());

        if (answer3 == 1 || answer3 == 3) {
            System.out.println("Sorry, the result is 11");
        } else if (answer3 == 2) {
            System.out.println("That's right!");
            numRight++;
        } else {
            System.out.println("You entered an invalid option");
        }
        System.out.println("Overall, you got " + numRight + " out of 3 correct.");
        System.out.println("Thanks for playing!");
    }
}
