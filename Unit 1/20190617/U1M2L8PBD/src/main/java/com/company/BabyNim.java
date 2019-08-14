package com.company;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 3;
        int b = 3;
        int c = 3;

        do {
        System.out.format("A: %d   B: %d   C: %d", a, b, c);
        System.out.println("");
        System.out.println("");
        System.out.println("Choose a pile: ");
        String pileChoice1 = scanner.nextLine();
        System.out.format("How many to remove from pile %s: ", pileChoice1);
        int removeNum1 = Integer.parseInt(scanner.nextLine());

        if (pileChoice1.equals("a") || pileChoice1.equals("A")) {
            a = a - removeNum1;
        } else if (pileChoice1.equals("b") || pileChoice1.equals("B")) {
            b = b - removeNum1;
        } else if (pileChoice1.equals("c") || pileChoice1.equals("C")) {
            c = c - removeNum1;
        } else {
            System.out.println("You did not enter a valid pile. Goodbye.");
        }
    } while (a > 0 || b > 0 || c > 0);
        System.out.format("A: %d   B: %d   C: %d", a, b, c);
        System.out.println("");
        System.out.println("All piles are empty. Good job!");
    }


}
