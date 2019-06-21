package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingTheLargestValueInAnArraylist {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i<10; i++){
            arrayList.add(random.nextInt(100)+1);
        }
        System.out.println("ArrayList: " + arrayList);
        int largest = arrayList.get(0);
        int largestIndex = 0;
        for (int i = 1; i <arrayList.size(); i++) {
            if (largest<arrayList.get(i)){
                largest = arrayList.get(i);
                largestIndex = i;
            }
        }
        System.out.println("");
        System.out.println("The largest value is " + largest + ", which is in slot " + largestIndex);
    }
}
