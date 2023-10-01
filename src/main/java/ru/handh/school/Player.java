package ru.handh.school;

public class Player extends Creature{
    private final String name;
    private int maxHealCounts = 4;
    private int healCounts;
    private final double maxHealingRatio = 0.3;
    private int maxHealingValue;
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + "maxHealCounts=" + maxHealCounts  + '}' + super.toString();
    }

    public Player(String name, int attack, int defence, int maxHealth, int minDamage,  int maxDamage) {
        super(name, attack, defence, maxHealth,  minDamage, maxDamage);
        this.name = name;
        this.maxHealingValue = (int) (maxHealth * maxHealingRatio);
        this.healCounts = maxHealCounts;
        System.out.println(name + " is here...");
    }

/**
 Игрок может себя исцелить до 4-х раз на 30% от максимального Здоровья.
 */
    public void heal(){
        if (healCounts > 0 && this.getHealth() < getMaxHealth()){
            int health = this.getHealth() + maxHealingValue;
            setHealth(Math.min(health, getMaxHealth()));
            healCounts--;
            System.out.println(this.name + " healed himself (+" +maxHealingValue + "hp)");
        }
    }
}
