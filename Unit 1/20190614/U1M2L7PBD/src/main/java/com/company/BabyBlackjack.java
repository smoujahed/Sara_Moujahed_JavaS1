package com.company;

import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random random = new Random();
        int playerCard1 = random.nextInt(10)+1;
        int playerCard2 = random.nextInt(10)+1;
        int playerCardSum = playerCard1+playerCard2;
        int dealerCard1 = random.nextInt(10)+1;
        int dealerCard2 = random.nextInt(10)+1;
        int dealerCardSum = dealerCard1+playerCard2;
        System.out.println("Baby Blackjack!");
        System.out.println("");
        System.out.println("You drew " +playerCard1+" and "+playerCard2+".");
        System.out.println("You totals is " + playerCardSum + ".");
        System.out.println("");
        System.out.println("The dealer has " +dealerCard1+" and "+dealerCard2+".");
        System.out.println("Dealer's totals is " + dealerCardSum + ".");
        System.out.println("");

        if (playerCardSum>dealerCardSum) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOSE!");
        }
    }
}
