package jr.discord.bot;


import jr.discord.bot.bot.Bot;
import jr.discord.bot.listener.GuildEventListener;

public class Main {
    public static void main(String[] args) {
        new Bot(new GuildEventListener());
    }
}
