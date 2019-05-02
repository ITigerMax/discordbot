package jr.discord.bot.listener;

import jr.discord.bot.constant.Colors;
import jr.discord.bot.bot.handler.EventHandler;
import jr.discord.bot.bot.handler.PrivateEventHandler;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;


import static jr.discord.bot.bot.handler.Commands.ADD_JR_ACCOUNT;
import static jr.discord.bot.constant.Messages.*;

public class GuildEventListener extends ListenerAdapter {

    private static final Logger LOGGER = JDALogger.getLog(GuildEventListener.class);
    private final EmbedBuilder greetingStyle;
    private final EmbedBuilder privateMessageStyle;

    public GuildEventListener() {
        greetingStyle = new EmbedBuilder()
                .setColor(Colors.WIGHT)
                .setTitle(PRIVATE_WELCOME_MESSAGE);

        privateMessageStyle = new EmbedBuilder();
    }


    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        LOGGER.info("User {} joined.", event.getMember().getUser().getId());

        greetingStyle.appendDescription(event.getMember().getEffectiveName() + HELP_INFO);

        event.getMember()
                .getUser()
                .openPrivateChannel()
                .queue(privateChannel -> {
                            privateChannel.
                                    sendMessage(greetingStyle.build()).queue();
                        }
        );
    }

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }
            EventHandler eh = new PrivateEventHandler(event);

        if (eh.getRowMessage().equalsIgnoreCase(EventHandler.BOT_NAME)){
            LOGGER.info(EventHandler.BOT_NAME);
            eh.sendMessageBack(privateMessageStyle.appendDescription(eh.getAuthorName() + "!\n")
                    .appendDescription(SKILL_INFO + ADD_JR_ACCOUNT).setColor(Colors.VIOLET));
        }else if (eh.getRowMessage().equalsIgnoreCase(ADD_JR_ACCOUNT)){
            eh.sendMessageBack(privateMessageStyle.appendDescription(INSERT_YOUR_ID).setColor(Colors.GREEN));
            //TODO implement request processing logic
        }
    }
}
