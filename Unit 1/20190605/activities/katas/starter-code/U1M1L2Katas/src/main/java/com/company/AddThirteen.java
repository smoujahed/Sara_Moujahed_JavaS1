package com.company;

import java.util.Scanner;
public class AddThirteen {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

        //collect input from user
        System.out.println("Enter number");
        int num = Integer.parseInt(input.nextLine());

        //calculate and display result
        int result = num + 13;
        System.out.println("adding 13...");
        System.out.println("Result is " + result);
    }
}
