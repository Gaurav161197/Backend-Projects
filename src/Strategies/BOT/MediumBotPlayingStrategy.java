package Strategies.BOT;

import Models.Board;
import Models.Cell;
import Models.CellStatus;
import Models.Move;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move suggesMove(Board board) {
        List<List<Cell>> gameBoard = board.getBoard();
        List<Cell> availableCells = getAvailableCells(gameBoard);
        int max=availableCells.size()-1;
        int min=0;
        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(max - min + 1) + min;
        Cell cell = availableCells.get(randomIndex);
        return new Move(cell);

    }

    private List<Cell> getAvailableCells(List<List<Cell>> board) {
        return board.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getCellStatus().equals(CellStatus.EMPTY))
                .collect(Collectors.toList());
    }
}
