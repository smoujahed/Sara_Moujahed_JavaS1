package com.company;

public class SomeMath {
    public static void main(String[] args) {
        System.out.println(total5(1,2,3,4,5));
        System.out.println(average5(1,3,5,7,9));
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));
    }
    public static int total5 (int num1, int num2, int num3, int num4, int num5){
        int sum = num1 + num2 + num3 + num4 +num5;
        return sum;
    }
    public static double average5 (int num1, int num2, int num3, int num4, int num5){
        double avg = (num1+num2+num3+num4+num5)/5;
        return avg;
    }
    public static double largest5 (double num1, double num2, double num3, double num4, double num5) {
        double largest = num1;

        if (largest<num2) {
            largest = num1;
        } else if (largest<num3) {
            largest = num3;
        } else if (largest<num4) {
            largest = num4;
        } else if (largest<num5) {
            largest = num5;
        }
        return largest;
    }
}
