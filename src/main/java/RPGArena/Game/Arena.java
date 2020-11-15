/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package RPGArena.Game;

import RPGArena.Game.Character.Character;
import RPGArena.Game.Character.Mage;
import RPGArena.Game.Character.Paladin;
import RPGArena.Game.Character.Rogue;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    public static Random generator = new Random();

    public static void arena() {
        boolean blank = true;
        boolean blank1 = true;
        boolean blank2 = true;

        boolean running = true;

        Character player1 = null;
        Character player2 = null;
//        player1.name = "Billy Bob";
//        player1.strength = 2;
//        player1.health = 50;
//        player1.defense = 1;
//
//        player2.name = "Steve";
//        player2.strength = 1;
//        player2.health = 50;
//        player2.defense = 2;

        while (running) {
            DiscordRPC.discordRunCallbacks();

            DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("Winning: ");
            presence.setBigImage("large", "RPGArena");
            presence.setDetails("Idle");
            DiscordRPC.discordUpdatePresence(presence.build());

            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (!input.equalsIgnoreCase("quit")) {
                if (input.equalsIgnoreCase("play")) {

                    if(blank){
                        player1 = new Character(0, 2);
                        player2 = new Character(10, 2);
                    }

                    System.out.println(player1.className + player1.name + " vs. " + player2.className + player2.name);
                    System.out.println(player1.health + " vs. " + player2.health + "\n");

                    DiscordRPC.discordRunCallbacks();
                    presence.setDetails("Playing RPGArena");
                    DiscordRPC.discordUpdatePresence(presence.build());

                    while (player1.isAlive() && player2.isAlive()) {

                        System.out.println(player1.name + ": " + player1.health);
                        System.out.println(player2.name + ": " + player2.health + "\n\n");

                        int damage;
                        damage = player1.attack(player2);
                        System.out.println(player1.name + " hits " + player2.name + " for " + damage);


                        damage = player2.attack(player1);
                        System.out.println(player2.name + " hits " + player1.name + " for " + damage + "\n");

                        if (!player1.isAlive() || !player2.isAlive()){
                            running = false;
                        }
                    }

                    if(player1.isAlive()) {
                        System.out.println(player1.name + " wins!");
                    } else if (player2.isAlive()) {
                        System.out.println(player2.name + " wins!");
                    } else {
                        System.out.println("It's a draw!");
                    }

                } else if(input.equalsIgnoreCase("custom")){
                    blank = false;

                    while (blank1 == true || blank2 == true) {

                            System.out.print("game-custom-p1 name> ");
                            in = new Scanner(System.in);
                            input = in.nextLine();
                            String name = input;

                            System.out.println("\nClasses: Fighter(Default), Mage, Paladin, and Rogue\n");
                            System.out.print("game-custom-p1 class> ");
                            in = new Scanner(System.in);
                            input = in.nextLine();

                            System.out.println("Enter strength");
                            System.out.print("game-custom-p1 Str> ");
                            in = new Scanner(System.in);
                            int inputInt= in.nextInt();
                            int strength = inputInt;


                            System.out.print("game-custom-p1 Def> ");
                            in = new Scanner(System.in);
                            inputInt = in.nextInt();
                            int defense = inputInt;


                            input.toLowerCase();
                            switch (input){
                                case "paladin":
                                    player1 = new Paladin(strength, defense);
                                    player1.name = name;
                                    blank1 = false;
                                case "rogue":
                                    player1 = new Rogue(strength, defense);
                                    player1.name = name;
                                    blank1 = false;
                                case "mage":
                                    player1 = new Mage(strength, defense);
                                    player1.name = name;
                                    blank1 = false;
                                default:
                                    player1 = new Character(strength, defense);
                                    player2.name = name;
                                    blank1 = false;
                            }
                            System.out.println("Player1 set to "+ player1.className + "\n");


                            System.out.print("game-custom-p2 name> ");
                            in = new Scanner(System.in);
                            input = in.nextLine();
                            name = input;

                            System.out.println("\nClasses: Fighter(Default), Mage, Paladin, and Rogue\n");
                            System.out.print("game-custom-p2 class> ");
                            in = new Scanner(System.in);
                            input = in.nextLine();

                            System.out.println("Enter strength");
                            System.out.print("game-custom-p2 Str> ");
                            in = new Scanner(System.in);
                            inputInt= in.nextInt();
                            strength = inputInt;


                            System.out.print("game-custom-p2 Def> ");
                            in = new Scanner(System.in);
                            inputInt = in.nextInt();
                            defense = inputInt;
                            switch (input) {
                                case "paladin":
                                    player2 = new Paladin(strength, defense);
                                    player2.name = name;
                                    blank2 = false;
                                case "rogue":
                                    player2 = new Rogue(strength, defense);
                                    player2.name = name;
                                    blank2 = false;
                                case "mage":
                                    player2 = new Mage(strength, defense);
                                    player2.name = name;
                                    blank2 = false;
                                default:
                                    player2 = new Character(strength, defense);
                                    player2.name = name;
                                    blank2 =  false;
                            }
                            System.out.println("Player2 set to "+ player2.className);

                            System.out.print("game-custom-p2 Str> ");
                            in = new Scanner(System.in);
                            inputInt= in.nextInt();
                            System.out.println("Enter strength");
                            player2.strength = inputInt;

                            System.out.print("game-custom-p2 Def> ");
                            in = new Scanner(System.in);
                            inputInt = in.nextInt();
                            System.out.println("Enter defence");
                            player2.defense = inputInt;

                        }
                      } else {
                        System.out.println("Unknown Command: " +
                                "\n\nAvailable Commands:" +
                                "\nplay - play game.\ncustom - make a custom character\nquit - End this test peacefully.");
                    }
            } else {
//                frame.dispose();
                System.exit(0);
            }
        }
    }

}
