package ru.handh.school;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("John",true, 8, 6, 5, 1, 6);
        Monster monster = new Monster("Kraken", true, 3, 5, 5, 1, 4);
        System.out.println(player.getName() + " ïs here");
        System.out.println(monster.getName() + " ïs here");
        if (player.hittingEnemy(player, monster)){
            System.out.println("hit");
            player.damageEnemy(player, monster);
        }
    }
}