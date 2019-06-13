package com.company;

import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter three integers:");

        int i = 1;
        int prev = 0;
        int side1 = 0;
        int side2 = 0;
        int side3 = 0;
        do {
            System.out.println("Side " + i + ":");
            int num = Integer.parseInt(scan.nextLine());
            if (num >= prev) {
                prev = num;
                if (i == 1){
                    side1=num;
                } else if (i == 2) {
                    side2=num;
                } else if (i == 3) {
                    side3=num;
                }
                i++;
            } else {
                System.out.println(num + " is smaller than " + prev + ". Try again.");
            }

        } while (i<4);
        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);
        int largest;
        if (side1 > side2 && side1 > side3){
            largest = side1;
            if (largest*largest == (side3*side3+side2*side2)) {
                System.out.println("Right triangle!");
            } else {
                System.out.println("Not a right triangle!");
            }
        } else if (side2 > side1 && side2 > side3){
            largest = side2;
            if (largest*largest == (side3*side3+side1*side1)) {
                System.out.println("Right triangle!");
            } else {
                System.out.println("Not a right triangle!");
            }
        } else {
            largest = side3;
            if (largest*largest == (side1*side1+side2*side2)) {
                System.out.println("That will make a right triangle!");
            } else {
                System.out.println("That will not make a right triangle!");
            }
        }

    }
}
