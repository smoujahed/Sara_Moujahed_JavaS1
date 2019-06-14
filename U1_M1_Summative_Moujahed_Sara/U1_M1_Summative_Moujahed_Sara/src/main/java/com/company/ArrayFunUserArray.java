package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[5];
        String stringIn;

        for (int i = 0; i < numbers.length; i++) {

            System.out.println("Please enter a number:");
            stringIn = scan.nextLine();
            numbers[i] = Integer.parseInt(stringIn);
        }
        for (int i = 0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }
}
