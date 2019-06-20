package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArraylist2 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> arrayList = new ArrayList<>(10);
        for (int i = 0; i<10; i++){
            arrayList.add(random.nextInt(101));
        }
        System.out.println("ArrayList: " + arrayList);
    }
}
