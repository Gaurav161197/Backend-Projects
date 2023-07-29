package Strategies.BOT;

import Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel.equals(BotDifficultyLevel.EASY))
            return new EasyBotPlayingStrategy();
        else if(difficultyLevel.equals(BotDifficultyLevel.MEDIUM))
            return new MediumBotPlayingStrategy();

        return null;
    }
}
