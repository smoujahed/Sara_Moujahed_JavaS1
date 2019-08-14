package com.company;

public class Memory {
    private String size;
    private int speed;
    private float frequency;

    public Memory(String size, int speed, float frequency) {
        this.size = size;
        this.speed = speed;
        this.frequency = frequency;
    }

    public String getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public float getFrequency() {
        return frequency;
    }
}