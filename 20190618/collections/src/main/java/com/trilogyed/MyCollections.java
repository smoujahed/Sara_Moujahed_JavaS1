package com.trilogyed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollections {
    public static void main(String[] args) {
        //List<String> names = new ArrayList<String>();
        List<String> names = new ArrayList<>();
        names.add("Joe");
        names.add("Sally");
        names.add("Bob");
        names.add("Jeff");
        names.add("Chris");
        names.add("Molly");

        //System.out.println("How many names do we have? " + names.size());

        System.out.println(names.get(0));

        names.add(1, "Brian");
        //System.out.println(names.get(1));
        //System.out.println(names.get(2));
        //System.out.println(names.size());

        //Accessing elements

        //for loop
        for(int i = 0; i<names.size(); i++) {
            System.out.println(names.get(i));
        }
        System.out.println("===================");
        //for each
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("===================");

        //iterator
        Iterator<String> iter = names.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
