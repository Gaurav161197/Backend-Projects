package Controller;

import Models.Game;
import Models.GameStatus;
import Models.Player;
import Service.GameService;
import Strategies.WinningStrategies.AntiDiagonalWinningStrategy;
import Strategies.WinningStrategies.ColWinningStrategy;
import Strategies.WinningStrategies.DiagonalWinningStrategy;
import Strategies.WinningStrategies.RowWinningStrategy;

import java.util.List;

public class GameController {

    public  Game instantiateGame(int dimension, List<Player> players) {
        return Game.getGameBuilder()
                .setPlayer(players)
                .setBoardDimension(dimension)
                .addWinningStrategy(new RowWinningStrategy())
                .addWinningStrategy(new ColWinningStrategy())
                .addWinningStrategy(new DiagonalWinningStrategy())
                .addWinningStrategy(new AntiDiagonalWinningStrategy())
                .build();
    }

    public  void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }

    public GameStatus checkGameStatus(Game game) {
        return game.getGameStatus();
    }

    public String getWinner(Game game) {
        return game.getWinner();
    }

    public void executeNextMove(Game game) {
        GameService gameService = new GameService();
        gameService.executeNextMove(game);
    }

}
