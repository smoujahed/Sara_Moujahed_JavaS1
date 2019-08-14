package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number between 15 and 32");
        int num = Integer.parseInt(input.nextLine());

        while (num < 15 || num > 32 ) {
            System.out.println("Out of Range. Enter a number between 15 and 32");
            num = Integer.parseInt(input.nextLine());
        }
        System.out.println(num);
    }
}
