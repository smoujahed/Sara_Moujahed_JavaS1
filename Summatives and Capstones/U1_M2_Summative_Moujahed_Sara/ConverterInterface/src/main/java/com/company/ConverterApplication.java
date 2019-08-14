package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        ConverterIf a = new ConverterIf();
        ConverterSwitch b = new ConverterSwitch();

        //demonstrate all month converter options from ConverterIf
        System.out.println("ConverterIf class demonstration...");
        System.out.println("convertMonth...");
        System.out.println("");
        System.out.println(a.convertMonth(1));
        System.out.println(a.convertMonth(2));
        System.out.println(a.convertMonth(3));
        System.out.println(a.convertMonth(4));
        System.out.println(a.convertMonth(5));
        System.out.println(a.convertMonth(6));
        System.out.println(a.convertMonth(7));
        System.out.println(a.convertMonth(8));
        System.out.println(a.convertMonth(9));
        System.out.println(a.convertMonth(10));
        System.out.println(a.convertMonth(11));
        System.out.println(a.convertMonth(12));
        System.out.println(a.convertMonth(13));
        System.out.println("");

        //demonstrate all day converter options from ConverterIf
        System.out.println("======================");
        System.out.println("convertDay...");
        System.out.println("");
        System.out.println(a.convertDay(1));
        System.out.println(a.convertDay(2));
        System.out.println(a.convertDay(3));
        System.out.println(a.convertDay(4));
        System.out.println(a.convertDay(5));
        System.out.println(a.convertDay(6));
        System.out.println(a.convertDay(7));
        System.out.println("");

        //demonstrate all month converter options from ConverterSwitch
        System.out.println("__________________________________________");
        System.out.println("ConverterSwitch class demonstration...");
        System.out.println("convertMonth...");
        System.out.println("");
        System.out.println(b.convertMonth(1));
        System.out.println(b.convertMonth(2));
        System.out.println(b.convertMonth(3));
        System.out.println(b.convertMonth(4));
        System.out.println(b.convertMonth(5));
        System.out.println(b.convertMonth(6));
        System.out.println(b.convertMonth(7));
        System.out.println(b.convertMonth(8));
        System.out.println(b.convertMonth(9));
        System.out.println(b.convertMonth(10));
        System.out.println(b.convertMonth(11));
        System.out.println(b.convertMonth(12));
        System.out.println(b.convertMonth(13));
        System.out.println("");

        //demonstrate all day converter options from ConverterSwitch
        System.out.println("======================");
        System.out.println("convertDay...");
        System.out.println("");
        System.out.println(b.convertDay(1));
        System.out.println(b.convertDay(2));
        System.out.println(b.convertDay(3));
        System.out.println(b.convertDay(4));
        System.out.println(b.convertDay(5));
        System.out.println(b.convertDay(6));
        System.out.println(b.convertDay(7));


    }
}
