package jr.discord.bot.bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

/**
 * Allows to encapsulate JDA instance and get BotPropertiesHolder implementation,
 * which contain bot token.
 * */
public class Bot {

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

}
