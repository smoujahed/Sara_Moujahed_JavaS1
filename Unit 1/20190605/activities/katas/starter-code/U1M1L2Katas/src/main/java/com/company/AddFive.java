package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect 5 numbers from user
        System.out.println("Enter first number");
        int num1 = Integer.parseInt(input.nextLine());

        System.out.println("Enter second number");
        int num2 = Integer.parseInt(input.nextLine());

        System.out.println("Enter third number");
        int num3 = Integer.parseInt(input.nextLine());

        System.out.println("Enter fourth number");
        int num4 = Integer.parseInt(input.nextLine());

        System.out.println("Enter fifth number");
        int num5 = Integer.parseInt(input.nextLine());

        //calculate and display total
        int total = num1 + num2 + num3 + num4 + num5;
        System.out.println("Total is " + total);
    }
}
