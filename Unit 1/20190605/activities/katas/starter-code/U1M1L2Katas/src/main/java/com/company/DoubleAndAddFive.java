package com.company;

import java.util.Scanner;
public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect and store user input
        System.out.println("Enter a number");
        int num = Integer.parseInt(input.nextLine());

        //calculate and display result
        int result = (num * 2) + 5;
        System.out.println("doubling and adding 5...");
        System.out.println("Result is " + result);
    }
}
