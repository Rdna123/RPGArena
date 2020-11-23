package RPGArena;

import RPGArena.Bot.RPGArenaBot;
import RPGArena.Game.Arena;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Commands {

    public static boolean mode = true;

    private static boolean ready = false;

    private static boolean quit = false;

    public static void main(String[] args) throws LoginException {
        mode = true;

        System.out.println("Mode Enter 'true' for online mode or 'false' for offline \n default is 'true'");
        System.out.print("mode > ");
        Scanner in = new Scanner(System.in);

        mode = in.nextBoolean();

        System.out.println(mode);

        if (mode)
            initDiscord();



        while (!quit) {
            if (mode) {
                DiscordRPC.discordRunCallbacks();
                if (!ready)
                    continue;


                DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("");
                presence.setBigImage("large", "RPGArena");
                presence.setDetails("Starting");
                DiscordRPC.discordUpdatePresence(presence.build());

                DiscordRPC.discordRunCallbacks();
            }

            System.out.print("Main Menu> ");
            in = new Scanner(System.in);
            String input = in.nextLine();

            if (!input.equalsIgnoreCase("shutdown")) {
                if (input.equalsIgnoreCase("game")) {
                    Arena.arena();
                } else if (input.equalsIgnoreCase("bot")) {
                    if (mode) {
                        RPGArenaBot.botStart();
                    } else {
                        System.out.println("This command not available in offline mode");
                    }
                } else if (input.equalsIgnoreCase("discord")){
                    System.out.println("Discord Server: https://discord.gg/ndG8bh73sy");
                }else {
                    System.out.println("Unknown Command: " +
                            "\n\nAvailable Commands:" +
                            "\nGame - Starts game.\nbot - starts bot\ndiscord - The official discord server" +
                            "\nshutdown - End this test peacefully.");
                }
            } else {
                quit = true;
                if (mode){
                    DiscordRPC.discordShutdown();}
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

