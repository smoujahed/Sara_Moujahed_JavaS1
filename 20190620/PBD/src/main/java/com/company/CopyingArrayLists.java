package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> arrayList = new ArrayList<>(10);
        List<Integer> arrayList2 = new ArrayList<>(arrayList.size());

        for (int i = 0; i<10; i++){
            arrayList.add(random.nextInt(101));
        }
        for (int i = 0; i<arrayList.size(); i++){
            arrayList2.add(i, arrayList.get(i));
        }
        arrayList.set(arrayList.size()-1, -7);
        System.out.println("ArrayList 1: " + arrayList);
        System.out.println("ArrayList 2: " + arrayList2);

    }
}
