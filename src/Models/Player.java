package Models;

import java.util.List;
import java.util.Scanner;

public class Player {
    private int playerId;
    private String name;
    private char symbol;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(int playerId, String name, char symbol, PlayerType playerType, Scanner sc) {
        this.playerId = playerId;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = sc;
    }

    public Move makeMove(Board board) {

        if (!isCellAvailable(board))
            return null;

        System.out.println("Enter row and column where you want to play the move");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int boardSize = board.getBoard().size();
        if (row > boardSize - 1 || col > boardSize - 1)
            throw new IllegalArgumentException("board does not have that given row or col available");


        if (board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.OCCUPIED)) {
            System.out.println("Cell is already occupied, please choose any other cell");
            makeMove(board);
        }


        board.getBoard().get(row).get(col).setPlayer(this);
        Cell cell = new Cell(row, col, this, CellStatus.OCCUPIED);
        return new Move(cell);
    }

    private boolean isCellAvailable(Board gameBoard) {
        List<List<Cell>> board = gameBoard.getBoard();
        return board.stream().flatMap(List::stream).anyMatch(cell -> cell.getCellStatus().equals(CellStatus.EMPTY));
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}

