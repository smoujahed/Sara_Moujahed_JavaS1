package com.company;

public class AnalogClock implements Clock {

    @Override
    public void displayTime() {
        System.out.println("<time>");
    }

    @Override
    public void timer(int hour, int minute) {
        System.out.println(hour+":"+minute);

    }
}
