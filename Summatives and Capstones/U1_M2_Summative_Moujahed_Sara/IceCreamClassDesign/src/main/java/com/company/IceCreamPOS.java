package com.company;

public class IceCreamPOS {
    private String flavor;
    private int numOfScoops;
    private boolean isCone;
    private double price;

    public IceCreamPOS (){}
    public IceCreamPOS(String flavor, int numOfScoops, boolean isCone, double price) {
        this.flavor = flavor;
        this.numOfScoops = numOfScoops;
        this.isCone = isCone;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getNumOfScoops() {
        return numOfScoops;
    }

    public void setNumOfScoops(int numOfScoops) {
        this.numOfScoops = numOfScoops;
    }

    public boolean isCone() {
        return isCone;
    }

    public void setCone(boolean cone) {
        isCone = cone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
