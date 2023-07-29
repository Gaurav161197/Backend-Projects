package Models;

public class Cell {

    private int col;
    private int row;

    private Player player;

    private CellStatus cellStatus;

    public Cell(int row, int col, Player player, CellStatus cellStatus) {
        this.col = col;
        this.row = row;
        this.player = player;
        this.cellStatus = cellStatus;
    }
    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
        this.cellStatus = CellStatus.EMPTY;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }
}
