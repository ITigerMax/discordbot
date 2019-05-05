package jr.discord.bot.bot.handler;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;

/**
 * Encapsulates behaviour of GuildMemberJoinEvent.
 * */
public class JoinEventHandler {

    /**
     * GuildMemberJoinEvent instance.
     * */
    private GuildMemberJoinEvent event;

    /**
     * Initialize GuildMemberJoinEvent instance.
     * @param event
     *          initializer of the member's joining event*/
    public JoinEventHandler(GuildMemberJoinEvent event) {
        this.event = event;
    }

    /**
     * Get official users's name of the guild's new member.
     * @return user's name.
     * */
    public String getMemberName() {
        return event.getMember().getUser().getName();
    }


    /**
     * Sends the decorated message to the private channel of new member,
     * which initializes current GuildMemberJoinEvent.
     * @param color
     *          the color of the left embed
     * @param title
     *          the main title of the message
     * @param args
     *          the different parts of general message,
     *          that can be combined to specified order by the wish of the code's user.
     * */
    public void sendPrivateMessage(int color, String title, String... args) {
        EmbedBuilder greetingStyle = new EmbedBuilder()
                .setColor(color)
                .setTitle(title)
                .appendDescription(getMemberName());
        for (String s : args) greetingStyle.appendDescription(s);

        event.getMember()
                .getUser()
                .openPrivateChannel()
                .queue(privateChannel -> {
                            privateChannel.
                                    sendMessage(greetingStyle.build()).queue();
                        }
                );
    }
}
