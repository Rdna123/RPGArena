package RPGArena.Bot;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPGArenaBot extends ListenerAdapter{

    private static String BOT_TOKEN;

    private static void read(){
        try {
            File myObj = new File("Bot.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                BOT_TOKEN = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public static void botStart() throws LoginException {
        read();
        JDA api = JDABuilder.createDefault(BOT_TOKEN).build();
        api.addEventListener(new MyListener());

    }
    public static class MyListener extends ListenerAdapter
    {
        @Override
        public void onMessageReceived(MessageReceivedEvent event)
        {
            if (event.getAuthor().isBot()) return;
            // We don't want to respond to other bot accounts, including ourself
            Message message = event.getMessage();
            String content = message.getContentRaw();
            // getContentRaw() is an atomic getter
            // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
            if (content.equals("!ping"))
            {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Pong!").queue();// Important to call .queue() on the RestAction returned by sendMessage(...)




                DiscordRichPresence.Builder presence = new DiscordRichPresence.Builder("Time Elapsed: " );
                presence.setBigImage("large", "RPGArena");
                presence.setDetails("Running RPGArena bot");
                DiscordRPC.discordUpdatePresence(presence.build());

                DiscordRPC.discordRunCallbacks();
            }
        }
    }
}

