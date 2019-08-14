package com.company;

public class Warrior extends Character{
    private int shieldStrength = 100;

    public Warrior() {
        super.strength = 75;
        super.stamina = 100;
        super.speed = 50;
        super.attackPower = 10;
    }

    public void decreaseShieldStrength (){
        shieldStrength--;
    }
    public void decreaseShieldStrength(int decreaseBy) {
        shieldStrength -= shieldStrength;
    }
}
