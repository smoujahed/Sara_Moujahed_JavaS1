package com.company;

public class Popcorn {
    private String brand;
    private String flavor;
    private String size;
    private double price;
    private int quantity;

    public Popcorn () {

    }
    public Popcorn(String brand, String flavor, String size, double price, int quantity) {
        this.brand = brand;
        this.flavor = flavor;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
