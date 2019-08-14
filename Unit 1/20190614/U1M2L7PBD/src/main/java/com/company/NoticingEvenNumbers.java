package com.company;

public class NoticingEvenNumbers {
    public static void main(String[] args) {
        int[] numbers = new int[20];
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = i+1;
            if (numbers[i]%2 == 0) {
                System.out.println(numbers[i] + "<");
            } else {
                System.out.println(numbers[i]);
            }
        }
    }
}
