package Properties;

import java.util.ArrayList;

/**
 * Board --- Creates the board which contains all properties related to the board
 * @author Chris Betancur
 * @author David Alvarez Tamayo
 */

public class Board {

    private Tile[][] board;
    private Snake snake;
    private final int DEFAULT_SNAKE_SIZE=5;

    public Board() {
        board = new Tile[64][64];
        snake = new Snake(DEFAULT_SNAKE_SIZE);
    }

    public Board(Tile[][] board) {
        this.board=board;
    }

    private void initBoard(){

    }

    private void initSnake(){

    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }
}
