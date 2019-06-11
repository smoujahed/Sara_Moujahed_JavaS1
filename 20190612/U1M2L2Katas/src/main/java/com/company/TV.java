package com.company;

public class TV {
    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    public TV (String manIn, String modelIn, int screenSizeIn, String channelIn, int volumeIn, boolean poweredIn){
        this.manufacturer = manIn;
        this.model = modelIn;
        this.screenSize = screenSizeIn;
        this.powered = poweredIn;
        this.channel = channelIn;
        this.volume = volumeIn;

    }
    public void togglePower() {
        if (powered == false) {
            powered = true;
        } else {
            powered = false;
        }
    }

    public int getVolume() {
        return volume;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getChannel() {
        return channel;
    }

    public boolean isPowered() {
        return powered;
    }
}
