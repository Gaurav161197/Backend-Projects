package Strategies.BOT;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    Move suggesMove(Board board);
}
