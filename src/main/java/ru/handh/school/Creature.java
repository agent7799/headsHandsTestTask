package ru.handh.school;

public class Creature {

    private static final int DICE_MIN_VALUE = 1;
    private static final int DICE_MAX_VALUE = 6;
    private static final int DICE_MIN_SUCCESSFUL_HIT_VALUE = 5;
    private final String name;
    private boolean isAlive;
    private int attack;
    private int defence;
    private final int maxHealth;
    private int Health;
    private int minDamage;
    private int maxDamage;

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        this.Health = health;
    }

    public Creature(String name, int attack, int defence, int maxHealth, int minDamage, int maxDamage) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHealth;
        this.Health = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public String toString() {
        return " attack=" + attack + ", defence=" + defence + ", health=" + Health + ", minDamage=" + minDamage + ", maxDamage=" + maxDamage + '}';
    }

    public void hit(Creature opponent) {
        if (this.tryToHitEnemy(this, opponent)) {
            System.out.println(this.name + "(" + this.getHealth() + "hp) hit " + opponent.name + "(" + opponent.getHealth() + "hp)!");
            this.damageEnemy(this, opponent);
        }else{
            System.out.println(this.name + " missed " + opponent.name + "!");
        }
    }

    /**
     * Одно Существо может ударить другое по такому алгоритму:
     *   - Рассчитываем Модификатор атаки. Он равен разности Атаки атакующего и Защиты защищающегося плюс 1
     *   - Успех определяется броском N кубиков с цифрами от 1 до 6, где N - это Модификатор атаки. Всегда бросается хотя бы
     *   один кубик.
     *   - Удар считается успешным, если хотя бы на одном из кубиков выпадает 5 или 6
     */
    public boolean tryToHitEnemy(Creature attacker, Creature defender) {
        int attackModifier = attacker.attack - defender.defence + 1;
        for (int i = 0; i < attackModifier; i++) {
            int chance = DICE_MIN_VALUE + (int) (Math.random() * (DICE_MAX_VALUE - DICE_MIN_VALUE + 1));
            if (chance >= DICE_MIN_SUCCESSFUL_HIT_VALUE) {
                return true;
            }
        }
        return false;
    }

    public void damageEnemy(Creature attacker, Creature defender) {
        int damage = attacker.minDamage + (int) (Math.random() * (attacker.maxDamage - attacker.minDamage + 1));
        System.out.println(defender.getName() + " damaged (-" + damage + "hp)");
        int remainingHealth = defender.getHealth() - damage;
        if (remainingHealth <= 0) {
            defender.setHealth(0);
            defender.setAlive(false);
            System.out.println(defender.getName() + " IS KILLED");
        } else {
            defender.setHealth(remainingHealth);
            System.out.println(defender.getName() + " remaining health " + remainingHealth);
        }
    }
}
