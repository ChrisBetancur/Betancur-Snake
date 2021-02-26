package Properties;

/**
 * Board --- Creates the board which contains all properties related to the board
 * @author Chris Betancur
 * @author David Alvarez Tamayo
 */

public class Board {

    private Tile[][] board;

    public Board() {
        board = new Tile[64][64];
    }

    public Board(Tile[][] board) {
        this.board=board;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }
}
