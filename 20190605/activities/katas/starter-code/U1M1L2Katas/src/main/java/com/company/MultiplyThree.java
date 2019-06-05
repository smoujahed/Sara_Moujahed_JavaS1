package com.company;


import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        System.out.println("Please enter a number");
        Scanner myScanner = new Scanner(System.in);

        //collect 3 numbers and store data
        System.out.println("Enter first number");
        int num1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter second number");
        int num2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter third number");
        int num3 = Integer.parseInt(myScanner.nextLine());

        //calculate and display result
        int result = num1 * num2 * num3;
        System.out.println("multiplying 3 numbers...");
        System.out.println("Result is " + result);
    }
}