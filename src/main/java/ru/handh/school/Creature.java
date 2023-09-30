package ru.handh.school;

public class Creature {

    private static final int cubeSideMinValue = 1;
    private static final int cubeSideMaxValue = 6;
    private static final int minSuccessfulHit = 5;
    private final String name;
    private boolean isAlive;
    //int 1 to 30
    private int attack;
    //int 1 to 30
    private int defence;
    private int health;
    private int minDamage;
    private int maxDamage;

    public Creature(String name, boolean isAlive, int attack, int defence, int health, int minDamage, int maxDamage) {
        this.name = name;
        this.isAlive = isAlive;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public String toString() {
        return " isAlive=" + isAlive + ", attack=" + attack + ", defence=" + defence + ", health=" + health + ", minDamage=" + minDamage + ", maxDamage=" + maxDamage + '}';
    }

    public boolean hittingEnemy(Creature attacker, Creature defender) {
        int attackModifier = attacker.attack - defender.defence + 1;
        for (int i = 0; i < attackModifier; i++) {
            int u = cubeSideMinValue + (int) (Math.random() * (cubeSideMaxValue - cubeSideMinValue + 1));
            if (u >= minSuccessfulHit){
               return true;
            }
        }
        return false;
    }

    public void damageEnemy(Creature attacker, Creature defender){
        int damage = attacker.minDamage + (int) (Math.random() * (attacker.maxDamage - attacker.minDamage +1));
        System.out.println(defender.getName() + ", health: " + defender.getHealth() + " damaged on  -" + damage + " hp");
       int remainingHealth =  defender.getHealth() - damage;
       if (remainingHealth <= 0){
           defender.setHealth(0);
           defender.setAlive(false);
           System.out.println(defender.getName() + " IS KILLED");
       }else{
           defender.setHealth(remainingHealth);
           System.out.println(defender.getName() + " remaining health " + remainingHealth);
       }
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
