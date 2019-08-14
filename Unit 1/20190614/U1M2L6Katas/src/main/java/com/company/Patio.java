package com.company;

public class Patio {
    private boolean isCovered;
    private boolean isEnclosed;
    private float floorArea;
    private float length;
    private float width;
    private String flooringType;


    public Patio(boolean isCovered, boolean isEnclosed, float floorArea, float length, float width, String flooringType) {
        this.isCovered = isCovered;
        this.isEnclosed = isEnclosed;
        this.floorArea = floorArea;
        this.length = length;
        this.width = width;
        this.flooringType = flooringType;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public void setCovered(boolean covered) {
        isCovered = covered;
    }

    public boolean isEnclosed() {
        return isEnclosed;
    }

    public void setEnclosed(boolean enclosed) {
        isEnclosed = enclosed;
    }

    public float getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(float floorArea) {
        this.floorArea = floorArea;
    }
    
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }


    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

}
