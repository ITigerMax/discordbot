package jr.discord.bot.bot.handler;

import jr.discord.bot.utilities.BotResourcesPropertiesHolder;
import net.dv8tion.jda.core.EmbedBuilder;

public interface EventHandler {

    String BOT_NAME = BotResourcesPropertiesHolder.getBotName();

    String getAuthorName();
    String getRowMessage();
    void  sendMessageBack(EmbedBuilder message);

}
