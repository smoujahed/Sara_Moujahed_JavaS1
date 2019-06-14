package com.company;

public class Chocolate {
    private String brand;
    private boolean isDark;
    private String size;
    private double price;
    private int quantity;

    public Chocolate (){}
    public Chocolate(String brand, boolean isDark, String size, double price, int quantity) {
        this.brand = brand;
        this.isDark = isDark;
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

    public boolean isDark() {
        return isDark;
    }

    public void setDark(boolean dark) {
        isDark = dark;
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
