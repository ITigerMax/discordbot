package jr.discord.bot.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotResourcesPropertiesHolder{


    private static final Properties properties;
    private static String token;
    private static String botName;

        static {
            properties = new Properties();
            try(InputStream in = BotResourcesPropertiesHolder.class
                .getClassLoader()
                .getResourceAsStream("properties/discord.properties")) {

                    properties.load(in);
                    token = properties.getProperty("token");
                    botName = properties.getProperty("name");

            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public static String getToken() {
         if (token == null) throw  new NullPointerException("Couldn't find the token property.");
         return token;
    }


    public static String getBotName() {
        if(botName == null) throw  new NullPointerException("The name of your bot is not determined.");
        return botName;
    }
}
