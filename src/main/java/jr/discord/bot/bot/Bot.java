package jr.discord.bot.bot;

import jr.discord.bot.utilities.BotResourcesPropertiesHolder;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

/**
 * Allows to encapsulate JDA instance. In the case JDA is a heart of the bot.
 * */
public class Bot {

    /**
     * Contain bot discord name.
     * */
    public static final String BOT_NAME = BotResourcesPropertiesHolder.getBotName();

    /**
     * Contain bot discord token.
     * */
    public  static final String TOKEN = BotResourcesPropertiesHolder.getToken();

    /**
     * Allows to create and run JDA instance.
     * @param token
     *          bot discord token
     * @param listenerAdapters
     *          event listener implementations
     * */
    public Bot (String token, ListenerAdapter... listenerAdapters) {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .addEventListener(listenerAdapters)
                    .build();
            jda.awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows to create and run JDA instance.
     * @param listenerAdapters
     *          event listener implementations
     * */
    public Bot (ListenerAdapter... listenerAdapters) {
       this(TOKEN);
    }



}
