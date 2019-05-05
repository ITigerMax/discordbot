package jr.discord.bot.utilities;

import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Responsible for getting and keeping certain parameters from
 * the configuration file, in order for the program to work properly.
 * */
public class BotResourcesPropertiesHolder{

    private static final Logger LOGGER = JDALogger.getLog(BotResourcesPropertiesHolder.class);
    /**
     * URL to the configuration explanation page.
     * */
    private static final String WIKI = "https://github.com/ITigerMax/discordbot/wiki/Discord-Bot-Configuration";

    /**
     * Token of the discord bot
     * */
    private static String token;

    /**
     * The name of the bot.
     * */
    private static String botName;

    /**
     * Responsible for reading the configuration file and initializing
     * static fields.
     * If configuration file, one ofe the declared properties  does not exist,
     * @throws BotConfigurationException
     * */
     static {
         Properties properties = new Properties();
         try(InputStream in = BotResourcesPropertiesHolder.class
                 .getClassLoader().getResourceAsStream("properties/discord.properties")) {
             BotConfigurationException.setWiki(WIKI);
             //If configuration file is not exist
             if (in == null) {
                      throw new BotConfigurationException("properties/discord.properties is not found in resources folder.");
             }

             properties.load(in);

             if ((token = properties.getProperty("token")) == null) {
                    throw new BotConfigurationException("Couldn't find the token property.");
             }

             if((botName = properties.getProperty("name")) == null || !botName.startsWith("@")) {
                    throw  new BotConfigurationException("The name of your bot is not determined");
             }

         } catch (IOException e) {
             StringBuilder sb = new StringBuilder();
             StackTraceElement[] elements = e.getStackTrace();
             for (StackTraceElement element : elements){
                 sb.append(element);
             }
             LOGGER.error(sb.toString());
         }
    }

    /**
     * @return bot token
     * */
    public static String getToken() {
            return token;
    }

    /**
     * @return bot name*/
    public static String getBotName() {

        return botName;
    }
}
