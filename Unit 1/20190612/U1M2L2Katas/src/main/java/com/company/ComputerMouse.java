package com.company;

public class ComputerMouse {
    private String manufacturer;
    private String model;
    private int xPos;
    private int yPos;
    private int[] lastClickedLocation;

    public ComputerMouse (String manufacturerIn, String modelIn, int xPosIn, int yPosIn, int[] lastClickedLocationIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.xPos = xPosIn;
        this.yPos = yPosIn;
        this.lastClickedLocation = lastClickedLocationIn;

    }

    public void move (int deltaX, int deltaY) {

    }

    public void click () {

    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getxPosition() {
        return xPos;
    }

    public int getyPosition() {
        return yPos;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

}
