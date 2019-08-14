package com.company;

import java.util.Scanner;

public class Input implements UserIO {

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        int i = Integer.parseInt(scan.nextLine());
        return i;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        long l = Long.parseLong(scan.nextLine());
        return l;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        double d = Double.parseDouble(scan.nextLine());
        return d;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        float f = Float.parseFloat(scan.nextLine());
        return f;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }
}
