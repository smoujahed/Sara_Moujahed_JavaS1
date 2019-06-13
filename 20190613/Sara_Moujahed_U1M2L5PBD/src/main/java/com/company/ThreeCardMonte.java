package com.company;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.println("You slide up to Fast Eddie's card table" +
                " and plop down your cash.");
        System.out.println("He glances at you out of the corner of his " +
                "eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println("");
        System.out.println("Which one is the ace?");
        System.out.println("        ##  ##  ##");
        System.out.println("        ##  ##  ##");
        System.out.println("         1   2   3");

        int guess = Integer.parseInt(scan.nextLine());
        int randNum = random.nextInt(2)+1;

        if (guess == randNum) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace card number was " + randNum);
        }
        switch (randNum) {
            case 1:
                System.out.println("        AA  ##  ##");
                System.out.println("        AA  ##  ##");
                System.out.println("         1   2   3");
                break;
            case 2:
                System.out.println("        ##  AA  ##");
                System.out.println("        ##  AA  ##");
                System.out.println("         1   2   3");
                break;
            case 3:
                System.out.println("        ##  ##  AA");
                System.out.println("        ##  ##  AA");
                System.out.println("         1   2   3");
        }


    }
}
