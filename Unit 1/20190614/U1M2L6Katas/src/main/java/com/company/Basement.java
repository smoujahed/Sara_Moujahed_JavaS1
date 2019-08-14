package com.company;

public class Basement {
    private float floorArea;
    private float wallArea;
    private float length;
    private float width;
    private float ceilingHeight;
    private String flooringType;
    private String wallCoveringType;

    public Basement(){}
    public Basement(float length, float width, float ceilingHeight, String flooringType, String wallCoveringType) {
        this.length = length;
        this.width = width;
        this.ceilingHeight = ceilingHeight;
        this.flooringType = flooringType;
        this.wallCoveringType = wallCoveringType;
        this.floorArea = length * width;
        this.wallArea = calcWallArea(length, width, ceilingHeight);
    }

    public float calcWallArea(float length, float width, float ceilingHeight) {
        float area = ((length*ceilingHeight) + (width*ceilingHeight))*2;
        return area;
    }

    public float getFloorArea() {
        return floorArea;
    }

    public float getWallArea() {
        return wallArea;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getCeilingHeight() {
        return ceilingHeight;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public String getWallCoveringType() {
        return wallCoveringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public void setWallCoveringType(String wallCoveringType) {
        this.wallCoveringType = wallCoveringType;
    }
}
