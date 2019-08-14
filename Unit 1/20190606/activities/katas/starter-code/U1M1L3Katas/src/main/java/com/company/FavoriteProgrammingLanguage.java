package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your favorite programming language?");
        String lang = input.nextLine();
        while (!lang.equals("Java")) {
            System.out.println("Wrong answer! Try again!");
            lang = input.nextLine();
        }
        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
