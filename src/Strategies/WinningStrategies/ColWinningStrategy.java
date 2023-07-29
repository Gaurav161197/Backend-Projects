package Strategies.WinningStrategies;

import Models.*;

public class ColWinningStrategy implements WinningStrategies{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int colToCheck = move.getCell().getCol();
        Player player = move.getCell().getPlayer();

        for (int i = 0; i < board.getBoard().size(); i++) {
            Cell cell = board.getBoard().get(i).get(colToCheck);
            if (cell.getCellStatus().equals(CellStatus.EMPTY)
                    || !cell.getPlayer().equals(player)) {
                return false;
            }
        }
        return true;
    }
}
