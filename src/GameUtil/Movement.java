package GameUtil;

import UserInterface.PrimaryWindow.GameWindow;
import Properties.Board;
import Properties.Direction;
import Properties.Snake;
import Properties.Tile;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import static Properties.Direction.*;
/**
 * Movement --- Controls movement of snake
 */
public class Movement {

    private Board board;
    private GameWindow gameWindow;
    private static Direction direction;
    private final int SNAKE_SHIFT=1;
    private int currRow,currCol;
    private boolean isGameLost;

    public Movement(Board board) {
        this.board = board;
        direction = board.getDefaultSnakeDirection();
        currRow=board.getSnake().getHead().getRow();
        currCol=board.getSnake().getHead().getCol();
        isGameLost = false;
        //moveSnake(10,currCol);
    }

    public void moveSnake(){

        this.moveSnake(direction);

        //board.printBoard();
    }

    private void moveSnake(Direction currDirection){
        if(isGameLost) {

        }
        int prevRow=0,prevCol=0;
        this.isSnakeOnFood();
        try {
            for (Tile tile : board.getSnake().getCurrentTiles()) {
                if (prevRow <= board.getBOARD_ROWS() && tile.equals(board.getSnake().getHead())) {
                    prevRow = tile.getRow();
                    prevCol = tile.getCol();
                    if (currDirection == DOWN) {
                        tile.setRow(SNAKE_SHIFT + prevRow);
                    }
                    if (currDirection == RIGHT) {
                        tile.setCol(SNAKE_SHIFT + prevCol);
                    }
                    if (currDirection == LEFT) {
                        tile.setCol(prevCol - SNAKE_SHIFT);
                        //prevCol+=SNAKE_VELOCITY;
                    }
                    if (currDirection == UP) {
                        tile.setRow(prevRow - SNAKE_SHIFT);
                    } else {
                        validateSnakePosition();
                    }
                    board.getGameBoard()[tile.getRow()][tile.getCol()].setContainsSnake(true);
                } else {
                    int tempRow = tile.getRow();
                    int tempCol = tile.getCol();
                    board.getGameBoard()[tempRow][tempCol].setContainsSnake(false);

                    tile.setRow(prevRow);
                    tile.setCol(prevCol);

                    prevRow = tempRow;
                    prevCol = tempCol;

                    validateSnakePosition();
                    //this.isSnakeOnFood();
                    board.getGameBoard()[tile.getRow()][tile.getCol()].setContainsSnake(true);
                }
            }
        }catch (ConcurrentModificationException e){
            //System.out.println("Ignore");
        }
        //board.printBoard();
        int size = 0;
        for(Tile tiles[] : board.getGameBoard()) {
            for(Tile tile : tiles) {
                if(tile.isContainsSnake()) {
                    size++;
                }
            }
        }
    }

    public void snakeGrowth() {
        Snake currSnake = board.getSnake();
        int temp = currSnake.getCurrentTiles().indexOf(currSnake.getCurrentTiles().getLast());
        int secondLast = --temp;

        int newSize = currSnake.getSnakeSize() + 1;
        Snake newSnake = new Snake(newSize);
        Tile newTile = null;
        int newRow = currSnake.getCurrentTiles().getLast().getRow();
        int newCol = currSnake.getCurrentTiles().getLast().getCol();

        if(currSnake.getCurrentTiles().get(secondLast).getCol()>currSnake.getCurrentTiles().getLast().getCol()) {
            newCol--;
        }
        else if(currSnake.getCurrentTiles().get(secondLast).getCol()<currSnake.getCurrentTiles().getLast().getCol()) {
            newCol++;
        }
        else if(currSnake.getCurrentTiles().get(secondLast).getRow()>currSnake.getCurrentTiles().getLast().getRow()) {
            newRow--;
        }
        else if(currSnake.getCurrentTiles().get(secondLast).getRow()<currSnake.getCurrentTiles().getLast().getRow()) {
            newRow++;
        }
        LinkedList<Tile> newCurrentTiles = currSnake.getCurrentTiles();
        //System.out.println(newRow);
        newTile = new Tile(true, false, newRow, newCol);
        //System.out.println(newRow);
        newCurrentTiles.add(newTile);

        newSnake.setCurrentTiles(newCurrentTiles);
        board.setSnake(newSnake);

        //gameWindow.cleanUpBoard();

    }

    public void setWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void simulateSnake(){
        for(int i = 0;i < 20; i++){
            direction = RIGHT;
            this.moveSnake();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void isSnakeOnFood() {
        //board.generateFood();
        //System.out.println("Head: "+board.getSnake().getHead().getRow()+" "+board.getSnake().getHead().getCol());
        //System.out.println("Food: "+board.getFoodRow()+" "+board.getFoodCol());
        if(board.getSnake().getHead().getRow() == board.getFoodRow()
                && board.getSnake().getHead().getCol() == board.getFoodCol()){
            board.generateFood();
            this.snakeGrowth();
        }
    }

    private void validateSnakePosition() {
        if(board.getSnake().getHead().getRow() >= board.getBOARD_ROWS()
                || board.getSnake().getHead().getRow() < 0
                || board.getSnake().getHead().getCol() >= board.getBOARD_COLUMNS()
                || board.getSnake().getHead().getCol() < 0 || isSnakeOnItself()){
            isGameLost = true;
        }
    }
    private boolean isSnakeOnItself() {
        for(Tile tile : board.getSnake().getCurrentTiles()) {
            //System.out.print(tile.toString() +" = ");
            //System.out.println(board.getSnake().getHead().toString());
            if(tile.getRow() == board.getSnake().getHead().getRow() && tile.getCol() == board.getSnake().getHead().getCol() && !tile.equals(board.getSnake().getCurrentTiles().getFirst())) {
                /*System.out.println(tile.toString());
                System.out.println(board.getSnake().getHead().toString());*/
                return true;
            }
        }
        return false;
    }

    public boolean isGameLost() {
        return isGameLost;
    }

    public void setGameLost(boolean gameLost) {
        isGameLost = gameLost;
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
