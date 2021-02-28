package Properties;

import java.awt.*;
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
    private ArrayList<Tile> snakeStartingPosition;

    private int foodRow;
    private int foodCol;

    private final int BOARD_ROWS=16;
    private final int BOARD_COLUMNS=16;
    private final int NUM_OF_TILES=256;


    public Board() {
        gameBoard = new Tile[BOARD_ROWS][BOARD_COLUMNS];
        snake = new Snake(DEFAULT_SNAKE_SIZE);
        snakeStartingPosition = new ArrayList<>();
        this.initSnake();
        this.initBoard();
        this.generateFood();
    }

    public Board(Tile[][] board) {
        this.gameBoard=board;
    }

    private void initBoard(){
        for(int row = 0;row<BOARD_ROWS;row++){
            for(int col = 0;col<BOARD_COLUMNS;col++){
                gameBoard[row][col] = new Tile(false,false,row,col);
                for(Tile tile:snake.getCurrentTiles()){
                    if(tile.getRow()==row && tile.getCol()==col){
                        gameBoard[row][col]=tile;
                    }
                }
            }
        }
    }

    private void initSnake(){
        if(snake!=null){
            ArrayList<Tile> snakeStartingPosition = new ArrayList<>();
            snakeStartingPosition.add(new Tile(true,false,0,7));
            snakeStartingPosition.add(new Tile(true,false,1,7));
            snakeStartingPosition.add(new Tile(true,false,2,7));
            snakeStartingPosition.add(new Tile(true,false,3,7));
            snakeStartingPosition.add(new Tile(true,false,4,7));

            snake.setCurrentTiles(snakeStartingPosition);
        }
    }

    private void generateFood(){
        for(int i = 0;i<NUM_OF_TILES;i++) {

            int randomCol = (int) (Math.random() * (BOARD_COLUMNS + 2));
            int randomRow = (int) (Math.random() * (BOARD_ROWS + 2));

            if(!gameBoard[randomRow][randomCol].isContainsSnake()){
                gameBoard[randomRow][randomCol].setContainsFood(true);
                foodRow = randomRow;
                foodCol = randomCol;
                System.out.println("Food: "+randomRow+" "+randomCol);
                break;
            }
        }
    }

    public void printBoard(){
        for(int row = 0;row<BOARD_ROWS;row++){
            if(row>9){
                System.out.print(row+" ");
            }
            else{
                System.out.print(row+"  ");
            }
            for(int col = 0;col<BOARD_COLUMNS;col++){
                if(gameBoard[row][col].isContainsSnake()){
                    System.out.print(gameBoard[row][col].isContainsSnake()+"  ");
                }
                else if(gameBoard[row][col].isContainsFood()){
                    System.out.print("Food  ");
                }
                else{
                    System.out.print(gameBoard[row][col].isContainsSnake()+" ");
                }
            }
            System.out.println();
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
