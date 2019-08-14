package com.company;

public class Car {
    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    public Car (String makeIn, String modelIn, String typeIn, String colorIn, String engineIn, String transmissionIn, int numDoorsIn, double mpgIn, int milesDrivenIn){
        this.make = makeIn;
        this.model = modelIn;
        this.type = typeIn;
        this.color = colorIn;
        this.engine = engineIn;
        this.transmission = transmissionIn;
        this.numDoors = numDoorsIn;
        this.mpg = mpgIn;
        this.milesDriven = milesDrivenIn;

    }

    public void drive (int miles) {

    }
    public void honk () {
        System.out.println("HONK!");
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getMpg() {
        return mpg;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public String getEngine() {
        return engine;
    }

    public String getMake() {
        return make;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getType() {
        return type;
    }


}
