package com.company;

public class Mints {
    private String brand;
    private String flavor;
    private double price;
    private int quantity;

    public Mints (){}
    public Mints(String brand, String flavor, double price, int quantity) {
        this.brand = brand;
        this.flavor = flavor;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
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
