package jr.discord.bot.utilities;

import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;


/**
 * Signals that starting configuration of the current discord program does not meet the requirements.
 * */
public class BotConfigurationException extends RuntimeException{

    private static final Logger LOGGER = JDALogger.getLog(BotConfigurationException.class);

    private static String wikiUrl;

    public BotConfigurationException(String reason){
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        String msg;
        String stackTrace = getStackTraceToInfoLog(elements);
        if (wikiUrl == null){
            msg = sb.append("Specify url to wiki page with configuration description. Use setWiki(url);")
                    .append(System.lineSeparator())
                    .append(stackTrace).toString();
            LOGGER.error(msg);
            System.exit(1);
        }
            msg = sb.append("{} See for detail: {}")
                    .append(System.lineSeparator())
                    .append(stackTrace).toString();
            LOGGER.error(msg,reason, wikiUrl);
            System.exit(1);
    }

    public static void setWiki(String url){
        wikiUrl = url;
    }

    private String getStackTraceToInfoLog(StackTraceElement[] elements){
        StringBuilder sb = new StringBuilder();
        for (int step = 1; step < elements.length; step++) {
            sb.append(elements[step])
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

}
