package com.company;

import java.util.Scanner;

public class ArrayFunReverseIt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = {1, 2, 3, 4, 5};
        int[] reverse = new int[numbers.length];
        String stringIn;
        int revIndexCounter = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {

            reverse[revIndexCounter] = numbers[i];
            revIndexCounter++;

        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Original index " + i + " = " + numbers[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Reverse index " + i + " = " + reverse[i]);
        }
    }


}
