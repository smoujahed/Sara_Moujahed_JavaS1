package com.company;

public class IceCreamFactory {
    private String flavor;
    private String size;
    private int quantity;
    private String expiration;
    private boolean isLowCal;

    public IceCreamFactory (){}
    public IceCreamFactory(String flavor, String size, int quantity, String expiration, boolean isLowCal) {
        this.flavor = flavor;
        this.size = size;
        this.quantity = quantity;
        this.expiration = expiration;
        this.isLowCal = isLowCal;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public boolean isLowCal() {
        return isLowCal;
    }

    public void setLowCal(boolean lowCal) {
        isLowCal = lowCal;
    }
}
