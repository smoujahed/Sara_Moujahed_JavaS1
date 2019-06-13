package com.company;

import java.util.Scanner;

public class MonthConverterSwitch {
    public static void main(String[] args) {
        convertMonth();

    }

    public static void convertMonth () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number 1-12 to show corresponding month");
        int input = Integer.parseInt(scan.nextLine());
        String month = "";

        switch (input) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }

        System.out.println(month);
    }
}
