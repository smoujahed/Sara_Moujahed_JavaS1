package com.company;

import java.util.Scanner;

public class MonthConverterIf {
    public static void main(String[] args) {
        convertMonth();

    }

    public static void convertMonth () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number 1-12 to show corresponding month");
        int input = Integer.parseInt(scan.nextLine());
        String month = "";

        if (input == 1) {
            month = "January";
        } else if (input == 2) {
            month = "February";
        } else if (input == 3) {
            month = "March";
        } else if (input == 4) {
            month = "April";
        } else if (input == 5) {
            month = "May";
        } else if (input == 6) {
            month = "June";
        } else if (input == 7) {
            month = "July";
        } else if (input == 8) {
            month = "August";
        } else if (input == 9) {
            month = "September";
        } else if (input == 10) {
            month = "October";
        } else if (input == 11) {
            month = "November";
        } else if (input == 12) {
            month = "December";
        } else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
        System.out.println(month);
    }


}
