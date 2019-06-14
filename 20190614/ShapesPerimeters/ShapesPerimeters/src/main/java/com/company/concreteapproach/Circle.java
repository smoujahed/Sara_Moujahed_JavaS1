package com.company.concreteapproach;

public class Circle extends Shape {

    private float radius = 0;

    public float area() {
        return (float) (3.14 * radius * radius);
    };

    public float perimeter() {
        return (float) (2 * 3.14 * radius);
    }

}
