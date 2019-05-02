package jr.discord.bot;


import jr.discord.bot.bot.Bot;
import jr.discord.bot.listener.GuildEventListener;
import jr.discord.bot.utilities.BotResourcesPropertiesHolder;

public class Main {

    public static void main(String[] args) {
        new Bot(BotResourcesPropertiesHolder.getToken(), new GuildEventListener());
    }
}
