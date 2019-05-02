package jr.discord.bot.bot.handler;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class PrivateEventHandler implements EventHandler {

    private final PrivateMessageReceivedEvent event;

    public PrivateEventHandler(PrivateMessageReceivedEvent event) {
        this.event = event;
    }


    @Override
    public String getAuthorName() { return event.getAuthor().getName(); }

    @Override
    public String getRowMessage() {
        return event.getMessage().getContentDisplay();
    }

    @Override
    public void sendMessageBack(EmbedBuilder message) {
        event.getChannel().sendMessage(message.build()).queue();
        message.clear();
    }
}
