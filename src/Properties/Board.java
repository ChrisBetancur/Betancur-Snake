package Properties;

import java.util.ArrayList;
import java.util.Random;

import static Properties.Directions.UP;

/**
 * Board --- Creates the board which contains all properties related to the board
 * @author Chris Betancur
 * @author David Alvarez Tamayo
 */

public class Board {

    private Tile[][] gameBoard;
    private Snake snake;

    private final int DEFAULT_SNAKE_SIZE=5;
    private Directions snakeDirection=UP;

    private int foodRow;
    private int foodCol;

    private final int BOARD_ROWS=64;
    private final int BOARD_COLUMNS=64;
    private final int NUM_OF_TILES=128;


    public Board() {
        gameBoard = new Tile[BOARD_ROWS][BOARD_COLUMNS];
        snake = new Snake(DEFAULT_SNAKE_SIZE);
    }

    public Board(Tile[][] board) {
        this.gameBoard=board;
    }

    private void initBoard(){
       /* Random rand = new Random();
        int randLimit = 64;

        int */

        for(int row = 0;row<BOARD_ROWS;row++){
            for(int col = 0;col<BOARD_COLUMNS;col++){
                gameBoard[row][col] = new Tile();
            }
        }
    }

    private void initSnake(){
        if(snake!=null){
            ArrayList<Tile> snakeStartingPosition = new ArrayList<>();
        }
    }



    public Tile[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Tile[][] board) {
        this.gameBoard = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getDEFAULT_SNAKE_SIZE() {
        return DEFAULT_SNAKE_SIZE;
    }
}
