package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manIn, String modelIn, int numSpeakerIn, String stationIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manIn;
        this.model = modelIn;
        this.numSpeaker = numSpeakerIn;
        this.station = stationIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }

    public void togglePower() {
        if (powered == false) {
            this.powered = true;
        } else {
            this.powered = false;
        }
    }

    public boolean isPowered() {
        return powered;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getStation() {
        return station;
    }

    public int getNumSpeakers() {
        return numSpeaker;
    }

    public int getVolume() {
        return volume;
    }
}
