package GameUtil;

import Properties.Board;
import Properties.Direction;
import Properties.Tile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import static Properties.Direction.*;
/**
 * Movement --- Controls movement of snake
 */
public class Movement {

    private Board board;
    private Direction direction;
    private final int SNAKE_VELOCITY=1;
    private int currRow,currCol;

    public Movement(Board board) {
        this.board = board;
        this.direction = board.getDefaultSnakeDirection();
        currRow=board.getSnake().getHead().getRow();
        currCol=board.getSnake().getHead().getCol();
        //moveSnake(10,currCol);
    }

    public void moveSnake(){

        this.moveSnake(direction);

        board.printBoard();
    }

    private void moveSnake(Direction currDirection){
        int prevRow=0,prevCol=0;
        for(Tile tile:board.getSnake().getCurrentTiles()){
            if(prevRow<=board.getBOARD_ROWS() && tile.equals(board.getSnake().getHead())){
                prevRow = tile.getRow();
                prevCol = tile.getCol();
                if(currDirection == DOWN){
                    tile.setRow(SNAKE_VELOCITY+prevRow);
                }
                if(currDirection == RIGHT){
                    tile.setCol(SNAKE_VELOCITY+prevCol);
                }
                if(currDirection == LEFT){
                    tile.setCol(prevCol-SNAKE_VELOCITY);
                    //prevCol+=SNAKE_VELOCITY;
                }
                if(currDirection == UP){
                    tile.setRow(prevRow-SNAKE_VELOCITY);
                }
                board.getGameBoard()[tile.getRow()][tile.getCol()].setContainsSnake(true);
            }
            else {
                int tempRow = tile.getRow();
                int tempCol = tile.getCol();
                board.getGameBoard()[tempRow][tempCol].setContainsSnake(false);

                tile.setRow(prevRow);
                tile.setCol(prevCol);

                prevRow = tempRow;
                prevCol = tempCol;
                board.getGameBoard()[tile.getRow()][tile.getCol()].setContainsSnake(true);
            }
            this.validateSnakePosition();
        }
        /*for(Tile tile:board.getSnake().getCurrentTiles()){
            System.out.println("Row: "+tile.getRow()+" Col: "+tile.getCol());
        }*/
    }

    public void simulateSnake(){
        for(int i = 0;i < 20; i++){
            direction = RIGHT;
            this.moveSnake();
            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    private boolean isSnakeOnFood() {
        return false;
    }

    private void snakeGrowth() {

    }

    private void validateSnakePosition(){
        if(board.getSnake().getHead().getRow() == board.getBOARD_ROWS() - 1
                || board.getSnake().getHead().getRow() == 0
                || board.getSnake().getHead().getCol() == board.getBOARD_COLUMNS() - 1
                || board.getSnake().getHead().getCol() == 0){
            board.printBoard();
            System.out.println("You lost");
            System.exit(0);
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
