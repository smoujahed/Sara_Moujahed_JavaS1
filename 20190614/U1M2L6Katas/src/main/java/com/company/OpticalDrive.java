package com.company;

public class OpticalDrive {
    private String brand;
    private String type;
    private int version;
    private int romSpeed;


    public OpticalDrive (){}
    public OpticalDrive(String brand, String type, int version, int romSpeed) {
        this.brand = brand;
        this.type = type;
        this.version = version;
        this.romSpeed = romSpeed;
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

    public int getRomSpeed() {
        return romSpeed;
    }
}
