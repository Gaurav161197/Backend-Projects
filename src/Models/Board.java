package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board(int dimension) {

        board = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoard() {
        int size = board.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j).getCellStatus().equals(CellStatus.EMPTY))
                    System.out.print("| - |");
                else
                    System.out.printf("| %s |", board.get(i).get(j).getPlayer().getSymbol());
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
