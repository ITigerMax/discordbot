package jr.discord.bot.bot.handler;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

import java.awt.*;

/**
 * Encapsulates behaviour of the PrivateMessageReceivedEvent.
 * */
public class PrivateEventHandler {

    /**
     * PrivateMessageReceivedEvent instance.
     * */
    private final PrivateMessageReceivedEvent event;

    /**
     * Initialize PrivateMessageReceivedEvent instance.
     * @param event
     *          initializer of the member's joining event
     * */
    public PrivateEventHandler(PrivateMessageReceivedEvent event) {
        this.event = event;
    }

    /**
     * Get the name of the author, which initializes the current event.
     * @return the name of the author.
     * */
    public String getAuthorName() { return event.getAuthor().getName(); }

    /**
     * Get the human readable message.
     * @return the human readable message.
     * */
    public String getRowMessage() { return event.getMessage().getContentDisplay(); }

    /**
     * Sends the decorated message to the channel, contained in the current event,
     * to the user from which was received.
     * @param color
     *          the color of the left embed
     * @param msg
     * */
    public void sendMessageBack(Color color, String msg) {
        EmbedBuilder message = new EmbedBuilder()
                .setColor(color)
                .setDescription(msg);

        event.getChannel().sendMessage(message.build()).queue();

        message.clearFields();
    }
}
