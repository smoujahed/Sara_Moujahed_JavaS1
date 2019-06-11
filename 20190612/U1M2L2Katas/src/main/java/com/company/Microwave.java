package com.company;

public class Microwave {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave (String manIn, String modelIn, int secondsLeftin, String timeIn, boolean runningIn) {
        this.manufacturer = manIn;
        this.model = modelIn;
        this.secondsLeft = secondsLeftin;
        this.time = timeIn;
        this.running = runningIn;
    }
     public void start (int secondsLeft) throws Exception {
         this.running = true;
         while(secondsLeft > 0) {
             System.out.println(secondsLeft);
             Thread.sleep(1000);
             secondsLeft--;
         }
     }

     public void stop () {
        this.running = false;
     }

     public void clear () {
        secondsLeft = 0;
        time = "0:00";

     }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public boolean isRunning() {
        return running;
    }
}
