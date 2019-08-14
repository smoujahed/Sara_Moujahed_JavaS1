package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number to count to");
        int num = Integer.parseInt(input.nextLine());

        int i = 0;
        while (i < (num+1)) {
            System.out.println(i);
            i = i+2;

        }
    }
}