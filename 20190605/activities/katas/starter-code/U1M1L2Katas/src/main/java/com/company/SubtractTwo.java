package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect and store 2 numbers
        System.out.println("Enter first number");
        int num1 = Integer.parseInt(input.nextLine());

        System.out.println("Enter second number");
        int num2 = Integer.parseInt(input.nextLine());

        //calculate and display result
        int result = - (num2 - num1);
        System.out.println("subtracting first number from second number...");
        System.out.println("Result is " + result);

    }
}
