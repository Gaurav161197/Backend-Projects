package Models;

import Strategies.WinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;

    private int currentPlayerIndex;

    private Player winner;

    private List<Move> moves;

    private List<WinningStrategies> winningStrategiesList;

    private GameStatus gameStatus;


    private Game(int dimension, List<WinningStrategies> winningStrategies, List<Player> players) {
        this.board = new Board(dimension);
        this.winningStrategiesList = winningStrategies;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 1;

    }

    public static GameBuilder getGameBuilder() {
        return new GameBuilder();
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
    public void setGameStatus(GameStatus status) {
         this.gameStatus=status;
    }

    public String getWinner() {
        return winner.getName();
    }
    public void setWinner(Player player) {
         this.winner = player;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }
    public void nextPlayerTurn(){
        this.currentPlayerIndex= (currentPlayerIndex+1)%players.size();
    }

    public List<WinningStrategies> getWinningStrategiesList(){
        return this.winningStrategiesList;
    }

    public void updateBoardWithCurrentMove(Move move) {
        int row= move.getCell().getRow();
        int col= move.getCell().getCol();
        this.board.getBoard().get(row).set(col,move.getCell());

    }

    public static class GameBuilder {

        List<Player> players;
        List<WinningStrategies> winningStrategiesList;

        int boardDimension;

        public GameBuilder() {
            this.players = new ArrayList<>();
            this.winningStrategiesList = new ArrayList<>();
            this.boardDimension = 0;
        }

        public GameBuilder setPlayer(List<Player> player) {
            this.players = player;
            return this;
        }

        public GameBuilder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public GameBuilder setWinningStrategiesList(List<WinningStrategies> winningStrategiesList) {
            this.winningStrategiesList = winningStrategiesList;
            return this;
        }

        public GameBuilder addWinningStrategy(WinningStrategies winningStrategy) {
            this.winningStrategiesList.add(winningStrategy);
            return this;

        }

        public GameBuilder setBoardDimension(int boardDimension) {
            this.boardDimension = boardDimension;
            return this;
        }

        public Game build() {
            return new Game(this.boardDimension, this.winningStrategiesList, this.players);
        }
    }

}
