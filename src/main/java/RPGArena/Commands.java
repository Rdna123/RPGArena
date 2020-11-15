package RPGArena;

import RPGArena.Bot.RPGArenaBot;
import RPGArena.Game.Arena;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Commands {

    private static boolean ready = false;

    private static boolean quit = false;

    public static void main(String[] args) throws LoginException {

        initDiscord();

        while (!quit) {
            DiscordRPC.discordRunCallbacks();

            if (!ready)
                continue;

            DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("");
            presence.setBigImage("large", "RPGArena");
            presence.setDetails("Starting");
            DiscordRPC.discordUpdatePresence(presence.build());

            DiscordRPC.discordRunCallbacks();


            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (!input.equalsIgnoreCase("shutdown")) {
                if (input.equalsIgnoreCase("game")) {
                    Arena.arena();
                } else if (input.equalsIgnoreCase("bot")) {
                    RPGArenaBot.botStart();
                } else {
                    System.out.println("Unknown Command: " +
                            "\n\nAvailable Commands:" +
                            "\nGame - Starts game.\nbot - starts bot\nshutdown - End this test peacefully.");
                }
            } else {
                quit = true;
                DiscordRPC.discordShutdown();
                System.exit(0);
            }
        }
    }
        private static void initDiscord(){
            DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
                ready = true;
                System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
                DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("");
                presence.setDetails("Running Test");
                DiscordRPC.discordUpdatePresence(presence.build());
            }).build();
            DiscordRPC.discordInitialize("776862425625395271", handlers, false);
            DiscordRPC.discordRegister("776862425625395271", "");
        }
    }

