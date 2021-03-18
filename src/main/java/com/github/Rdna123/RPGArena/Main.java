/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.Rdna123.RPGArena;

import com.github.Rdna123.RPGArena.Game.Arena;
import com.github.Rdna123.RPGArena.Utils.Input;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;


public class Main {

    public static boolean mode = true;
    public static String command;
    private static boolean ready = false;
    private static boolean quit = false;

    public static void main(String[] args) {


        mode = true;


        boolean loginSuccess = login();


        while (!quit) {
            if (loginSuccess) {
                DiscordRPC.discordRunCallbacks();
                if (!ready)
                    continue;

                DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("");
                presence.setBigImage("large", "com/github/Rdna123/RPGArena");
                presence.setDetails("Starting");
                DiscordRPC.discordUpdatePresence(presence.build());

                DiscordRPC.discordRunCallbacks();
            }

            command = Input.inString("Main Menu");

            if (!command.equals("shutdown")) {
                switch (command) {
                    case "s":
                        end();

                        break;
                    case "game":
                    case "g":
                        Arena.game();

                        break;
                    case "discord":
                    case "d":

                        System.out.println("Discord Server: https://discord.gg/ndG8bh73sy");

                        break;
                    case "mode":
                    case "m":

                        login();

                        break;
                    default:
                        System.out.println("Unknown Command: " +
                                "\n\nAvailable Commands:" +
                                "\nGame - Starts game.\ndiscord - The official discord server" +
                                "\nmode - Allows Change of game mode" +
                                "\nshutdown - End this test peacefully.");
                        break;
                }
            } else {
                end();
            }
        }
    }

    public static boolean login() {

        System.out.println("Mode Enter 'true' for online mode or 'false' for offline \n default is 'true'");
        String obj = Input.inString("Mode");

        while (true) {
            if (obj.equals("true") || obj.equals("t") || obj.isEmpty()) {
                mode = true;
                break;
            } else if (obj.equals("false") || obj.equals("f")) {
                if (mode) {
                    DiscordRPC.discordShutdown();
                }
                mode = false;
                break;
            } else {
                System.out.println("Please enter valid word\n" +
                        "Mode Enter 'true' for online mode or 'false' for offline \ndefault is 'true'");

                obj = Input.inString("Mode");
            }
        }
        if (mode) {
            System.out.println("Yes");
            initDiscord();
            System.out.println("no");
            return true;
        }
        return false;
    }

    private static void end() {
        quit = true;
        if (mode) {
            DiscordRPC.discordShutdown();
        }
        System.exit(0);
    }

    private static void initDiscord() {
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

