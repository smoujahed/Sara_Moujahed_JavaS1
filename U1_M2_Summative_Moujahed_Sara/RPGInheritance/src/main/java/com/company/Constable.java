package com.company;

public class Constable extends Character{

    private String jurisdiction;

    public Constable(String jurisdictionIn) {
        super.strength = 60;
        super.stamina = 60;
        super.speed = 20;
        super.attackPower = 5;
        this.jurisdiction = jurisdictionIn;
    }

    public void arrest (){
        System.out.println("Arresting...");
    }

    public String getJurisdiction() {

        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}

