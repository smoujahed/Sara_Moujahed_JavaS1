package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArraylist1 {
    public static void main(String[] args) {
        List<Integer> arrayList= new ArrayList<>(10);
        for (int i = 0; i<10; i++){
            arrayList.add(-113);
        }
        for (int i = 0; i<arrayList.size(); i++){
            System.out.println("Slot " + i + " contains a " + arrayList.get(i));
        }
    }
}
