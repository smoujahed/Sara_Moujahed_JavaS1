package com.company;

public class Kitchen {
    private String stoveType;
    private boolean islandExists;
    private float floorArea;
    private float wallArea;
    private float length;
    private float width;
    private float ceilingHeight;
    private String flooringType;
    private String wallCoveringType;

    public Kitchen(){}
    public Kitchen(String stoveType, boolean islandExists, float floorArea, float wallArea, float length, float width, float ceilingHeight, String flooringType, String wallCoveringType) {
        this.stoveType = stoveType;
        this.islandExists = islandExists;
        this.floorArea = floorArea;
        this.wallArea = wallArea;
        this.length = length;
        this.width = width;
        this.ceilingHeight = ceilingHeight;
        this.flooringType = flooringType;
        this.wallCoveringType = wallCoveringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public void setWallCoveringType(String wallCoveringType) {
        this.wallCoveringType = wallCoveringType;
    }

    public void setStoveType(String stoveType) {
        this.stoveType = stoveType;
    }

    public void setIslandExists(boolean islandExists) {
        this.islandExists = islandExists;
    }

    public String getStoveType() {
        return stoveType;
    }

    public boolean isIslandExists() {
        return islandExists;
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

}
