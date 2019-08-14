package com.company;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String[] words = new String[5];

            for (int i = 0; i < words.length; i++) {

                System.out.println("Please enter a word:");
                words[i] = scan.nextLine();
            }
            for (int i = 0; i < words.length; i++) {
                System.out.println("Index " + i + " = " + words[i]);
            }
        }
    }


