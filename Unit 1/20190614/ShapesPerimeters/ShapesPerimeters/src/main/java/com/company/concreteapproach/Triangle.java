package com.company.concreteapproach;

public class Triangle extends Shape {

    private float side1 = 0;
    private float side2 = 0;
    private float side3 = 0;
    private float height = 0;
    private float base = 0;

    public float area() {
        return (height * base) /2;
    };

    public float perimeter() {
        return side1 + side2 + side3;
    }

}
