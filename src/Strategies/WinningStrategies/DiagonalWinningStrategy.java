package Strategies.WinningStrategies;

import Models.Board;
import Models.Cell;
import Models.CellStatus;
import Models.Move;

import java.util.List;

public class DiagonalWinningStrategy implements WinningStrategies {
    @Override
    public boolean checkWinner(Board board, Move move) {
        List<List<Cell>> gameBoard = board.getBoard();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (row == col) {
            for (int i = 0; i < gameBoard.size(); i++) {
                Cell cell = gameBoard.get(i).get(i);
                if (!cell.getCellStatus().equals(CellStatus.OCCUPIED) ||
                        !cell.getPlayer().equals(move.getCell().getPlayer())) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
