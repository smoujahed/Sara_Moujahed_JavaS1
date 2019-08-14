package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 100");
        int num = Integer.parseInt(input.nextLine());

        while (num != 42) {
            System.out.println("Try another number");
            num = Integer.parseInt(input.nextLine());
        }
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
