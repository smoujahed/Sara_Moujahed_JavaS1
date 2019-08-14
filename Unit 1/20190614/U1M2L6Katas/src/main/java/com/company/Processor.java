package com.company;

public class Processor {
    private String brand;
    private String type;
    private int version;
    private int numOfCores;
    private String cache;

    public Processor(){}
    public Processor(String brand, String type, int version, int numOfCores, String cache) {
        this.brand = brand;
        this.type = type;
        this.version = version;
        this.numOfCores = numOfCores;
        this.cache = cache;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getVersion() {
        return version;
    }

    public int getNumOfCores() {
        return numOfCores;
    }

    public String getCache() {
        return cache;
    }
}
