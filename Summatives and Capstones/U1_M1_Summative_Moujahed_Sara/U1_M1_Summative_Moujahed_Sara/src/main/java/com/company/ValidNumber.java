package com.company;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
//        validateNum();
//    }
//
//    public static void validateNum () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number 1-10");
        int input = Integer.parseInt(scan.nextLine());
        while (input < 1 || input > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            input = Integer.parseInt(scan.nextLine());
        }
        System.out.println(input);
    }
}
