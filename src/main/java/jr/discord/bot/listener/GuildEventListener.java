package jr.discord.bot.listener;

import jr.discord.bot.bot.Bot;
import jr.discord.bot.bot.handler.JoinEventHandler;
import jr.discord.bot.bot.handler.PrivateEventHandler;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;


import java.awt.*;

import static jr.discord.bot.constant.Messages.*;

/**
 * Class that implements the methods of ListenerAdapter, defining behavior of the bot.
 * */
public class GuildEventListener extends ListenerAdapter {

    private static final Logger LOGGER = JDALogger.getLog(GuildEventListener.class);

    public GuildEventListener() {

    }

    /**
     * Define the bot's reaction, if new member is joining to the server.
     * */
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        JoinEventHandler jh = new JoinEventHandler(event);
        LOGGER.info("User {} joined.", jh.getMemberName());
        jh.sendPrivateMessage(
                new Color(191, 64, 191),
                PRIVATE_WELCOME_MESSAGE,
                jh.getMemberName() + HELP_INFO

        );

    }

    /**
     * Define the bot's reaction, if message was received to bot's private channel.
     * */
    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        LOGGER.info(event.toString());
        if (event.getAuthor().isBot()){
            return;
        }
           PrivateEventHandler ph = new PrivateEventHandler(event);
        if (ph.getRowMessage().equalsIgnoreCase(Bot.BOT_NAME)){
            ph.sendMessageBack(
                    new Color(0, 153, 0),
                    HELLO + ph.getAuthorName() + System.lineSeparator() + SKILL_INFO
            );
        }
    }
}
