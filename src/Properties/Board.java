package Properties;

public class Board {

    private Tile[][] board = new Tile[64][64];

    public Board() {
    }

    public Board(Tile[][] board) {
        this.board = board;
    }
}
