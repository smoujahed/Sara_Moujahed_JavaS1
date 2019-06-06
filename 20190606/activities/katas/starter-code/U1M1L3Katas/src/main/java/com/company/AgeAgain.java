package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How old are you?");
        int age = Integer.parseInt(input.nextLine());

        if (age < 14) {
            System.out.println("What grade are you in?");
            String grade = input.nextLine();
            System.out.println("Wow! " +grade+ " grade - that sounds exciting!");
        } else if (age > 18) {
            System.out.println("What is your profession?");
            String job = input.nextLine();
            System.out.println(job + " sounds like a great job!");
        } else {
            System.out.println("Are you planning to go to college? yes/no");
            String collegeAfterSchool = input.nextLine();
             if (collegeAfterSchool.equals("yes")) {
                 System.out.println("What college?");
                 String college = input.nextLine();
                 System.out.println(college + " is a great school!");
             } else {
                 System.out.println("What do you plan to do after school?");
                 String plan = input.nextLine();
                 System.out.println("Wow, " +plan+ " sounds like a plan!");
             }

        }

    }
}
