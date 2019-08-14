package com.company;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int currentNum = 1;
        int max = 101;


        while (currentNum < max) {
            if (currentNum%3 == 0 && currentNum%5 == 0) {
                System.out.println("FIZZBUZZ");
                currentNum++;
            } else if (currentNum%5 == 0) {
                System.out.println("BUZZ");
                currentNum++;
            } else if (currentNum%3 == 0) {
                System.out.println("FIZZ");
                currentNum++;
            } else {
                System.out.println(currentNum);
                currentNum++;
            }

        }
    }
}

