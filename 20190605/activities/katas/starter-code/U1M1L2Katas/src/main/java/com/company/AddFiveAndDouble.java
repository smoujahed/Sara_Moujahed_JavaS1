package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect input number
        System.out.println("Enter a number");
        int userNum = Integer.parseInt(input.nextLine());

        //calculate and display result
        int finalNum = (userNum + 5) * 2;
        System.out.println("Result is " + finalNum);


    }
}
