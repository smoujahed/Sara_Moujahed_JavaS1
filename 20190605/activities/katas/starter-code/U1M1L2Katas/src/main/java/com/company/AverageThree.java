package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect and store 3 numbers
        System.out.println("Enter first number");
        int num1 = Integer.parseInt(input.nextLine());

        System.out.println("Enter second number");
        int num2 = Integer.parseInt(input.nextLine());

        System.out.println("Enter third number");
        int num3 = Integer.parseInt(input.nextLine());

        //calculate and display average

        float average = (float) (num1 + num2 + num3)/3;
        System.out.format("Result is %.2f", average);
    }
}
