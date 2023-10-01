package ru.handh.school;

public class Monster extends Creature {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Monster{" + "name='" + name + '\'' + '}' + super.toString();
    }

    public Monster(String name, int attack, int defence, int maxHealth, int minDamage, int maxDamage) {
        super(name, attack, defence, maxHealth, minDamage, maxDamage);
        this.name = name;
        System.out.println(name + " is here...");
    }
}
