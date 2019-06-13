package com.company;

public class DigitalClock implements Clock, Alarm {
    @Override
    public void sound() {
        System.out.println("BWAAAAAA");
    }

    @Override
    public void displayTime() {
        System.out.println("<Time>");

    }

    @Override
    public void timer(int hour, int minute) {
        System.out.println(hour + ":" + minute);
    }
}
