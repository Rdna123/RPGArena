/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.Rdna123.RPGArena.Game;

import com.github.Rdna123.RPGArena.Commands;
import com.github.Rdna123.RPGArena.Game.Character.Player;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.Scanner;

public class Arena {

    private static DiscordRichPresence.Builder presence;
    public static boolean blank = true;

    public static Player player1, player2;
    public static void arena() {


        boolean running = true;

        player1 = new Player(0, 2);
        player2 = new Player(0, 2);
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

            if (Commands.mode) {
                DiscordRPC.discordRunCallbacks();

                presence = new DiscordRichPresence.Builder("Winning: ");
                presence.setBigImage("large", "com/github/Rdna123/RPGArena");
                presence.setDetails("Idle");
                DiscordRPC.discordUpdatePresence(presence.build());


            }
            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (!input.equalsIgnoreCase("quit")) {
                if(input.equalsIgnoreCase("custom")){

                    customize.custom();

                } else if (input.equalsIgnoreCase("play")) {

                    if (blank){
                        player1 = new Player(12, 10);
                        player2 = new Player(5, 10);
                    }

                    System.out.println(player1.className + player1.name + " vs. " + player2.className + player2.name);
                    System.out.println(player1.health + " vs. " + player2.health + "\n");

                    if (Commands.mode) {
                        DiscordRPC.discordRunCallbacks();
                        presence.setDetails("Playing RPGArena");
                        DiscordRPC.discordUpdatePresence(presence.build());
                    }

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
                } else {
                    System.out.println("Unknown Command: " +
                            "\n\nAvailable Commands:" +
                            "\nplay - play game.\ncustom - make a custom character\nquit - End this test peacefully.");
                    }
            } else {
//                frame.dispose();
               // System.exit(0);
                running=false;
            }
        }
    }

}
