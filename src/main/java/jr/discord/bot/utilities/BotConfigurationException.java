package jr.discord.bot.utilities;

import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;

import java.io.FileNotFoundException;

/**
 * Signals that starting configuration of the current discord program does not meet the requirements.
 * */
public class BotConfigurationException extends RuntimeException{

    private static final Logger LOGGER = JDALogger.getLog(BotConfigurationException.class);

    /**
     * Log to console the default reason of the exception.
     * @param url
     *          url where the explanation is located
     * @throws FileNotFoundException
     * */
    public BotConfigurationException(String url){
        LOGGER.error("properties/discord.properties is not found in resources folder\nSee for detail: " + url,
                new FileNotFoundException());
    }

    /**
     * Log to console the reason of the exception.
     * @param param
     *          reason of the exception
     * @param url
     *          url where the explanation is located
     * */
    public BotConfigurationException(String param, String url){
        if (param == "token") {
            LOGGER.error("\nCouldn't find the token property.\nSee for detail: " + url);
        }
        if (param == "botName") {
            LOGGER.error("\nThe name of your bot is not determined.\nSee for detail: " + url);
        }
    }

}
