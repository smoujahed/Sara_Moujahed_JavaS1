package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your age");
        int age = Integer.parseInt(input.nextLine());



        if (age >= 18) {
            System.out.println("Can vote");
        }
        if (age >= 21) {
            System.out.println("Can Drink alcohol");
        }
        if (age >= 35) {
            System.out.println("Can be president");
        }
        if (age >= 55) {
            System.out.println("Is eligible for AARP");
        }
        if (age >= 65) {
            System.out.println("Can retire");
        }
        if (age >= 80 && age <= 89) {
            System.out.println("Is an octogenerian");
        }
        if (age >= 100) {
            System.out.println("Is more than a century old");
        }



    }
}
