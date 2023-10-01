package ru.handh.school;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("John", 6, 5, 15, 1, 3);
        Monster monster = new Monster("Kraken", 6, 5, 13, 1, 4);
        battle(player, monster);
    }

    private static void battle(Player player, Monster monster) {
        System.out.println("Battle Starts!");
        int round = 1;
        while (true){
            System.out.println("\n" + "Round: " + round);
            player.hit(monster);
            if (!monster.isAlive()){
                break;
            }
            monster.hit(player);
            if (!player.isAlive()){
                break;
            }
            player.heal();
            round++;
        }
        System.out.println("Battle finished!!!");
    }
}