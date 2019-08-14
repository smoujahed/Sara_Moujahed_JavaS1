package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArraylist {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(51));
        }
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Value to find: ");
        int value = scanner.nextInt();

        for (int i = 0; i < arrayList.size(); i++) {
            if(value == arrayList.get(i)){
                System.out.println(value + " is in the ArrayList.");
            }
        }
    }
}
