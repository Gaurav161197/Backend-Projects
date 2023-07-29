package Service;

import Models.*;
import Strategies.WinningStrategies.WinningStrategies;

public class GameService {

    public void executeNextMove(Game game) {
        Player currentPlayer = game.getCurrentPlayer();
        Move move = currentPlayer.makeMove(game.getBoard());

       if (move == null) {
            game.setGameStatus(GameStatus.DRAW);
            return;
        }

        game.updateBoardWithCurrentMove(move);


        boolean isPlayerWon = false;
        for (WinningStrategies winningStrategies : game.getWinningStrategiesList()) {
            isPlayerWon = winningStrategies.checkWinner(game.getBoard(), move);
            if (isPlayerWon) {
                game.setWinner(currentPlayer);
                game.setGameStatus(GameStatus.OVER);
            }
        }
        game.nextPlayerTurn();


    }
}
