package com.trilogyed;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(6)+1;

        System.out.println("Fortune cookie says: " );

        switch (n) {
            case 1:
                System.out.print("The fortune you seek is in another cookie.");
                break;
            case 2:
                System.out.print("An alien of some sort will be appearing to you shortly.");
                break;
            case 3:
                System.out.print("He who throws dirt is losing ground.");
                break;
            case 4:
                System.out.print("You will be hungry again in one hour.");
                break;
            case 5:
                System.out.print("Help! I am being held prisoner in a fortune cookie factory.");
                break;
            case 6:
                System.out.print("A foolish man listens to his heart. A wise man listens to cookies.");
                break;
        }
        String lotto = "";
         for (int i = 0; i<=6; i++) {
             if (i == 0) {
                 lotto = lotto +(random.nextInt(54) + 1);

             } else {
                 lotto = lotto + " - " + (random.nextInt(54) + 1);
             }
         }
        System.out.println("    " + lotto);
    }
}
