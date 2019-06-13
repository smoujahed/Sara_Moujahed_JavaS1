package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[7];

        System.out.println("I will add up the numbers you give me.");
        int i = 0;
        int sum = 0;
        while (i < numbers.length) {
            System.out.println("Number:");
            int num = Integer.parseInt(scan.nextLine());
            if (num == 0) {
                break;
            } else {
                numbers[i] = num;
                sum += numbers[i];
                i++;
            }
        }
        System.out.println("The total is " + sum);
    }
}
