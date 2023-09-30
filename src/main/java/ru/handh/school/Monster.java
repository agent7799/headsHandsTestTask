package ru.handh.school;

public class Monster extends Creature {
    private String name;

    public Monster(String name, boolean isAlive, int attack, int defence, int health, int minDamage,  int maxDamage) {
        super(name, isAlive, attack, defence, health, minDamage, maxDamage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Monster{" + "name='" + name + '\'' + '}' + super.toString();
    }
}
