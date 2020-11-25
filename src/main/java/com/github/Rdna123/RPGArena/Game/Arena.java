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

import com.github.Rdna123.RPGArena.Game.Character.Player;
import com.github.Rdna123.RPGArena.Main;
import com.github.Rdna123.RPGArena.Game.Character.Fighter;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.swing.*;
import java.util.Scanner;

public class Arena {



    private static DiscordRichPresence.Builder presence;
    public static boolean blank = true;

    public static boolean running;
    public static Player fighter1, fighter2;

    public static void arena() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        running = true;

        graphics.game();


        fighter1 = new Fighter(0, 2);
        fighter2 = new Fighter(0, 2);
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

            if (Main.mode) {
                DiscordRPC.discordRunCallbacks();

                presence = new DiscordRichPresence.Builder("Winning: ");
                presence.setBigImage("large", "com/github/Rdna123/RPGArena");
                presence.setDetails("Idle");
                DiscordRPC.discordUpdatePresence(presence.build());


            }
            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            Main.command = input.replaceAll("\\s", "").toLowerCase();

            if (!Main.command.equals("quit")) {
                if(Main.command.equals("custom")){

                    customize.custom();

                } else if (Main.command.equals("play")) {

                    if (blank){
                        fighter1 = new Fighter(12, 10);
                        fighter2 = new Fighter(5, 10);
                    }

                    System.out.println(fighter1.getClassName() + fighter1.getName() + " vs. " + fighter2.className + fighter2.name);
                    System.out.println(fighter1.getHealth() + " vs. " + fighter2.getHealth() + "\n");

                    if (Main.mode) {
                        DiscordRPC.discordRunCallbacks();
                        presence.setDetails("Playing RPGArena");
                        DiscordRPC.discordUpdatePresence(presence.build());
                    }

                    while (fighter1.isAlive() && fighter2.isAlive()) {

                        System.out.println(fighter1.name + ": " + fighter1.health);
                        System.out.println(fighter2.name + ": " + fighter2.health + "\n\n");

                        int damage;
                        damage = fighter1.attack(fighter2);
                        System.out.println(fighter1.getName() + " hits " + fighter2.getName() + " for " + damage);


                        damage = fighter2.attack(fighter1);
                        System.out.println(fighter2.getName() + " hits " + fighter1.getName() + " for " + damage + "\n");

                        if (!fighter1.isAlive() || !fighter2.isAlive()){
                            running = false;
                        }
                    }

                    if(fighter1.isAlive()) {
                        System.out.println(fighter1.getName() + " wins!");
                    } else if (fighter2.isAlive()) {
                        System.out.println(fighter2.getName() + " wins!");
                    } else {
                        System.out.println("It's a draw!");
                    }
                } else {
                    System.out.println("Unknown Command: " +
                            "\n\nAvailable Commands:" +
                            "\nplay - play game.\ncustom - make a custom character\nquit - End this test peacefully.");
                    }
            } else {
               graphics.frame.dispose();
               running=false;
            }
        }
    }

}
