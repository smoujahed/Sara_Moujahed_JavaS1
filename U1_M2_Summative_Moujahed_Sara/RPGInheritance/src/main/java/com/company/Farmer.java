package com.company;

public class Farmer extends Character {

    public Farmer() {
        super.strength = 75;
        super.stamina = 75;
        super.speed = 10;
        super.attackPower = 1;
    }
    public void plow(){
        System.out.println("Plowing...");
    }
    public void harvest(){
        System.out.println("Harvesting...");
    }
}
