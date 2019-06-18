package com.company;

import java.util.HashSet;
import java.util.Iterator;

public class SetIterator {

    public void printSet (int a, int b, int c, int d, int e){
        HashSet<Integer> set = new HashSet<>(5);
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);

        Iterator<Integer> i = set.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        set.clear();
    }
}
