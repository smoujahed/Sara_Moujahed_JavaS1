package com.company;

import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {
        //generate random number
        Random randomGen = new Random();

        //assign essential variables
        int i = 1;
        int timesTilFirst7 = 1;     //counts rolls until first seven
        int numSevens = 0;          //counts sevens
        boolean firstFound = false; //verifies if first seven has been found

        //while loop to roll 100 times
        while (i<101) {

            //generate random number and assign it to a variable
            //two dice are rolled, so number must start at 2 and end at 12
            int randomNum = randomGen.nextInt(11);
            randomNum = randomNum+2;
            System.out.println(randomNum);

            //check if number generated is seven, count accordingly
            if (randomNum == 7) {
                numSevens++;
                firstFound = true;
            } else if (firstFound == false) {
                timesTilFirst7++;
            }
            i++;


        }

        //print results
        System.out.println("It took " + timesTilFirst7 + " rolls to get to the first 7");
        System.out.println("There were " + numSevens + " sevens");
    }

}
