package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private List<Classmate> classmates = new ArrayList<>();

    public void add (Classmate c){
        classmates.add(c);
    }
    public Classmate get (int i) {
        return classmates.get(i);
    }

    public List<Classmate> getAll (){
        return classmates;
    }
}
