package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //collect and store max value from user
        System.out.println("Enter max value");
        int max = Integer.parseInt(input.nextLine());

boolean isPrime;
int i = 2;
        while(i < max){
            if(i%(i-1) == 0){
                isPrime = false;
            } else {
                isPrime = true;
            }
            if (isPrime){
                System.out.println(i);
            }
            i++;
        }



        //loop
//        boolean isPrime = false;
//        int i = 2;
//        int num = 1;
//        while (num < max) {
//            if (num == 1) {
//                System.out.println(num);
//                num++;
//            } else {
//                while (i <= max) {
//                    if (max % i == 0) {
//                        isPrime = true;
//                        break;
//                    }
//                    ++i;
//                }
//            }
//
//            if (!isPrime) {
//                System.out.println(num);
//                num++;
//            } else {
//                num++;
            }
        }



        //while loop
//        int i=1;
//        while (i < max) {
//
//            if (i == 1) {
//                System.out.println(i);
//            } else if (i%(i-1) == 0) {
//                i++
//            } else {
//
//                i++;
//            }
//        }

