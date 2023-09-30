package ru.handh.school;

public class Player extends Creature{

    private final String name;

    public Player(String name, boolean isAlive, int attack, int defence, int health, int minDamage,  int maxDamage) {
        super(name, isAlive, attack, defence, health, minDamage, maxDamage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + '}' + super.toString();
    }
}
