package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number:");
        int num = Integer.parseInt(scan.nextLine());
        while (num < 0) {
            System.out.println("You can't take the square root of a negative number, silly");
            num = Integer.parseInt(scan.nextLine());
        }
        double sqrt = Math.sqrt(num);
        System.out.println("The square root of " + num + " is " + sqrt + ".");
    }
}
