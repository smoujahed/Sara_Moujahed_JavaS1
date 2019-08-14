package com.company;
import java.lang.*;
import java.util.*;
public class BetterInput implements UserIO {

    public int readInt(String prompt)throws IllegalFormatException {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        int i = 0;
        try {
            i = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You did not enter an integer");
            readInt(prompt);
        }
        return i;
    }

    @Override
    public long readLong(String prompt) throws IllegalFormatException {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        long l = 0;
        try {
            l = Long.parseLong(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You did not enter an long");
            readLong(prompt);
        }
        return l;
    }

    @Override
    public double readDouble(String prompt) throws IllegalFormatException {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        double d = 0;
        try {
            d = Double.parseDouble(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a double");
            readDouble(prompt);
        }
        return d;
    }

    @Override
    public float readFloat(String prompt) throws IllegalFormatException {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        float f = 0;
        try {
            f = Float.parseFloat(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a float");
            readFloat(prompt);
        }
        return f;
    }

    @Override
    public String readString(String prompt) throws IllegalFormatException {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        String s = "";
        try {
            s = scan.nextLine();
        } catch (IllegalFormatException e) {
            System.out.println("You did not enter a string");
            readString(prompt);
        }
        return s;
    }
}
