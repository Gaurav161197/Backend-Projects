package Strategies.WinningStrategies;

import Models.Board;
import Models.Cell;
import Models.CellStatus;
import Models.Move;

import java.util.List;

public class AntiDiagonalWinningStrategy implements WinningStrategies {
    @Override
    public boolean checkWinner(Board board, Move move) {
        List<List<Cell>> gameBoard = board.getBoard();
        int n = gameBoard.size();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (col == (n - row - 1)) {
            for (int i = 0; i < gameBoard.size(); i++) {
                Cell cell = gameBoard.get(i).get(n - i - 1);
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
