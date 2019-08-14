package com.company;

import sun.awt.AWTAccessor;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect information
        System.out.println("Enter mortgage amount");
        int mortgage = Integer.parseInt(input.nextLine());

        System.out.println("Enter term");
        int term = Integer.parseInt(input.nextLine());

        System.out.println("Enter annual interest rate");
        double interest = Double.parseDouble(input.nextLine());

        //calculate monthly interest rate in decimal
        double rate = (interest/100)/12;

        //calculate, round, and display mortgage payment
        double payment = (mortgage*(rate * Math.pow((1 + rate), term)))/(Math.pow((1 + rate), term) - 1);
        System.out.println("Monthly payment is: " + payment);
    }
}
