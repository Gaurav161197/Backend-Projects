package Models;

import Strategies.BOT.BotPlayingStrategy;
import Strategies.BOT.BotPlayingStrategyFactory;

import java.util.Scanner;

public class Bot extends Player {
    BotDifficultyLevel difficultyLevel;
    BotPlayingStrategy botPlayingStrategy;


    public Bot(int playerId, String name, char symbol, BotDifficultyLevel difficultyLevel, Scanner sc) {
        super(playerId, name, symbol, PlayerType.BOT,sc);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);

    }

    @Override
    public Move makeMove(Board board) {

        Move move = botPlayingStrategy.suggesMove(board);

        if(move==null)
            return null;

        System.out.printf("Bot is making move at row %s and col %s",move.getCell().getRow(),move.getCell().getCol());
        System.out.println();
        System.out.println();

        move.getCell().setPlayer(this);
        move.getCell().setCellStatus(CellStatus.OCCUPIED);

        return move;
    }
}

