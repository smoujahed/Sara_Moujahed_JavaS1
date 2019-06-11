package com.trilogyed;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double gravity = 1;

        //gather weight
        System.out.println("Please enter your current Earth weight:");
        int weight = Integer.parseInt(scan.nextLine());

        //gather planet
        System.out.println("I have information on the following planets:");
        System.out.println("1. Venus");
        System.out.println("2. Mars");
        System.out.println("3. Jupiter");
        System.out.println("4. Saturn");
        System.out.println("5. Uranus");
        System.out.println("6. Neptune");
        System.out.println("Which planet are you visiting? Enter number 1-6:");
        int planetNum = Integer.parseInt(scan.nextLine());

        //switch to determine which number was entered
        if (planetNum == 1) {
            gravity = .78;
        } else if (planetNum == 2) {
            gravity = .39;
        } else if (planetNum == 3) {
            gravity = 2.56;

        } else if (planetNum == 4) {
            gravity = 1.17;

        } else if (planetNum == 5) {
            gravity = 1.05;
        } else if (planetNum == 6) {
            gravity = 1.23;
        } else {
            System.out.println("You did not enter a valid number. Program is now exiting, goodbye!");
        }

        double planetWeight = weight*gravity;
        System.out.println("Your weight would be " + planetWeight + " pounds on this planet.");

    }
}
