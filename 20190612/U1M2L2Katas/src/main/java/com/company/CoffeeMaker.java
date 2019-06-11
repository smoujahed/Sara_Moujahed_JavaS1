package com.company;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker (String manufacturerIn, String modelIn, int carafeSizeIn, int cupsLeftIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.carafeSize = carafeSizeIn;
        this.cupsLeft = cupsLeftIn;
        this.powered = poweredIn;
    }

    public void brew(){
    }

    public void pourCoffee (int numCaps) {

    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public boolean isPowered() {
        return powered;
    }
}
