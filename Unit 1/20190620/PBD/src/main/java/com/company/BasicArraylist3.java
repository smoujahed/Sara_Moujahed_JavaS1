package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArraylist3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> arrayList = new ArrayList<>(1000);
        for (int i = 0; i<1000; i++){
            arrayList.add(random.nextInt(80)+10);
        }
        System.out.println("ArrayList: " + arrayList);
    }
}
