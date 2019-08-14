package com.company;

public class Phone {
    private String brand;
    private String model;
    private String processor;
    private int storage;
    private int price;

    public Phone(String brand, String model, String processor, int storage, int price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.storage = storage;
        this.price = price;
    }

    public Phone(){}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
