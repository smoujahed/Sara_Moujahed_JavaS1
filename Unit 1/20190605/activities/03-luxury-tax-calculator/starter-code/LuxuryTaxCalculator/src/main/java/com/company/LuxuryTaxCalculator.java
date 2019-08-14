package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int spendLimit = 40000000;

        //Prompt the user to enter the salary for Player 1
        System.out.println("Enter the salary for Player 1 (without the dollar sign or commas)");
        int salary1 = Integer.parseInt(input.nextLine());

        //Prompt the user to enter the salary for Player 2
        System.out.println("Enter the salary for Player 2 (without the dollar sign or commas)");
        int salary2 = Integer.parseInt(input.nextLine());

        //Prompt the user to enter the salary for Player 3
        System.out.println("Enter the salary for Player 3 (without the dollar sign or commas)");
        int salary3 = Integer.parseInt(input.nextLine());

        //Calculate and display the total salary for all three players
        int sum = salary1 + salary2 + salary3;
        System.out.println("Total salary is $" + sum);

        if (sum > spendLimit){

            //calculate luxury tax
            int remainder = sum - spendLimit;
            int tax = (int) (remainder * 0.18);

            //print total
            System.out.println("Total tax is $" + tax);

        } else {
            System.out.println("You did not exceed spending limit");
        }
    }
}
