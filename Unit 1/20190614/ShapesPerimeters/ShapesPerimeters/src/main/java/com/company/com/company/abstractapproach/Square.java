package com.company.com.company.abstractapproach;

public class Square extends Shape {

    private float length = 0;
    private float width = 0 ;


    public float area() {
        return length * width;
    }

    public float perimeter() {
        return length * 2 + width * 2;
    }

}

