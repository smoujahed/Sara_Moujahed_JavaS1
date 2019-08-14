package com.company;

public class Character {
    String name;
    int strength;
    int health = 100;
    int stamina;
    int speed;
    int attackPower;

    public Character(){};

    public void run(){
        System.out.println("Running...");
    }
    public void attack() {
        System.out.println("Attacking...");
    }
    public void heal(){
        System.out.println("Healing...");
    }
    public void decreaseHealth(){
        health--;
    }
    public void decreaseHealth(int decreasedBy){
        health -= decreasedBy;
    }
    public void increaseStamina(){
        stamina++;
    }
    public void increaseStamina(int increaseBy){
        stamina += increaseBy;

    }
    public void decreaseStamina(){
        stamina--;
    }
    public void decreaseStamina(int decreaseBy){
        stamina += decreaseBy;

    }
}
