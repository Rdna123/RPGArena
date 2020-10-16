package test.java.io.github.rdna123.RPGArena;

import java.util.Random;

public class Arena {
    public static Random generator = new Random();
    public static void main(String[] args) {
        Character player1 = new Paladin(9, 2, 100);
        Character player2 = new Character(9, 2, 100);
//        player1.name = "Billy Bob";
//        player1.strength = 2;
//        player1.health = 50;
//        player1.defense = 1;
//
//        player2.name = "Steve";
//        player2.strength = 1;
//        player2.health = 50;
//        player2.defense = 2;

        System.out.println(player1.className + player1.name + " vs. " + player2.className + player2.name);
        System.out.println(player1.health + " vs. " + player2.health + "\n");

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println(player1.name + ": " + player1.health);
            System.out.println(player2.name + ": " + player2.health + "\n\n");

            int damage;
            damage = player1.attack(player2);
            System.out.println(player1.name + " hits " + player2.name + " for " + damage);


            damage = player2.attack(player1);
            System.out.println(player2.name + " hits " + player1.name + " for " + damage + "\n");
        }

        if(player1.isAlive()) {
            System.out.println(player1.name + " wins!");
        } else if (player2.isAlive()) {
            System.out.println(player2.name + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
