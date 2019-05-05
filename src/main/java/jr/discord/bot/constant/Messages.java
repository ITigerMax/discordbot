package jr.discord.bot.constant;

/**
 * Represents the basic set of bot's messages.
 * */
public final class Messages {

    public static final String PRIVATE_WELCOME_MESSAGE = "Добро пожаловать в discord группу JavaRush.";

    public static final String HELP_INFO = " , для получения информации используй мое имя, как упоминание.";

    public static final String SKILL_INFO = "В данный момент мои умения не определены. Ждите! Скоро я захвачу мир!\nШутка!";

    private Messages() {
        throw new UnsupportedOperationException();
    }
}
