package com.company;

public class Bathroom {
    private boolean isHalfBath;
    private String bathType;
    private int numOfBathrooms;
    private float floorArea;
    private float wallArea;
    private float length;
    private float width;
    private float ceilingHeight;
    private String flooringType;
    private String wallCoveringType;
    private int numOfWalls;

    public Bathroom (){}
    public Bathroom(boolean isHalfBath, String bathType, int numOfBathrooms, float floorArea, float wallArea, float length, float width, float ceilingHeight, String flooringType, String wallCoveringType, int numOfWalls) {
        this.isHalfBath = isHalfBath;
        this.bathType = bathType;
        this.numOfBathrooms = numOfBathrooms;
        this.floorArea = floorArea;
        this.wallArea = wallArea;
        this.length = length;
        this.width = width;
        this.ceilingHeight = ceilingHeight;
        this.flooringType = flooringType;
        this.wallCoveringType = wallCoveringType;
        this.numOfWalls = numOfWalls;
    }

    public void setWallCoveringType(String wallCoveringType) {
        this.wallCoveringType = wallCoveringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public boolean isHalfBath() {
        return isHalfBath;
    }

    public String getBathType() {
        return bathType;
    }

    public int getNumOfBathrooms() {
        return numOfBathrooms;
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

    public int getNumOfWalls() {
        return numOfWalls;
    }
}
