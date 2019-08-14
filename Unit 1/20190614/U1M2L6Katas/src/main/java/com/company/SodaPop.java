package com.company;

public class SodaPop {
    private String brand;
    private String variety;
    public boolean isBottle;
    private double price;
    private int quantity;

    public SodaPop () {

    }
    public SodaPop(String brand, String variety, boolean isBottle, double price, int quantity) {
        this.brand = brand;
        this.variety = variety;
        this.isBottle = isBottle;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public boolean isBottle() {
        return isBottle;
    }

    public void setBottle(boolean bottle) {
        isBottle = bottle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
