package RPGArena;

import RPGArena.Character.Character;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    private static boolean ready = true;
    public static Random generator = new Random();

    public static void main(String[] args) {
        initDiscord();

        Character player1 = new Character(0, 2, 100);
        Character player2 = new Character(1, 2, 100);
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
            DiscordRPC.discordRunCallbacks();

            if(!ready)
                continue;

            DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("Winning: ");
            presence.setBigImage("large", "RPGArena");
            presence.setDetails("Idle");
            DiscordRPC.discordUpdatePresence(presence.build());

            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (!input.equalsIgnoreCase("shutdown")) {
                if (input.equalsIgnoreCase("test")) {
                    presence.setDetails("Running Test");
                    DiscordRPC.discordUpdatePresence(presence.build());
                    while (player1.isAlive() && player2.isAlive()) {

                        System.out.println(player1.name + ": " + player1.health);
                        System.out.println(player2.name + ": " + player2.health + "\n\n");

                        int damage;
                        damage = player1.attack(player2);
                        System.out.println(player1.name + " hits " + player2.name + " for " + damage);


                        damage = player2.attack(player1);
                        System.out.println(player2.name + " hits " + player1.name + " for " + damage + "\n");
                        
                    }
                } else {
                    System.out.println("Unknown Command: " +
                            "\n\nAvailable Commands:" +
                            "\ntest - Test.\nshutdown - End this test peacefully.");
                }
            } else {
//                frame.dispose();
                System.exit(0);
            }
        }


        if(player1.isAlive()) {
            System.out.println(player1.name + " wins!");
            DiscordRPC.discordShutdown();
        } else if (player2.isAlive()) {
            System.out.println(player2.name + " wins!");
            DiscordRPC.discordShutdown();
        } else {
            System.out.println("It's a draw!");
            DiscordRPC.discordShutdown();
        }
    }
    private static void initDiscord() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            Arena.ready = true;
            System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
            DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("Score: ");
            presence.setDetails("Running Test");
            DiscordRPC.discordUpdatePresence(presence.build());
        }).build();
        DiscordRPC.discordInitialize("776862425625395271", handlers, false);
        DiscordRPC.discordRegister("776862425625395271", "");
    }
}
