package Properties;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Snake --- Create Snake which contains all properties relating to Snake
 */

public class Snake {

    private int snakeSize;
    private int speed;
    private Tile head;
    private Tile tail;
    private LinkedList<Tile> currentTiles;

    public Snake(int snakeSize) {
        this.snakeSize = snakeSize;
        this.currentTiles = new LinkedList<>();
    }

    public int getSnakeSize() {
        return snakeSize;
    }

    public void setSnakeSize(int snakeSize) {
        this.snakeSize = snakeSize;
    }

    public void addToSnake(){

    }

    public LinkedList<Tile> getCurrentTiles() {
        return currentTiles;
    }

    public void setCurrentTiles(LinkedList<Tile> currentTiles) {
        this.currentTiles = currentTiles;
        head=currentTiles.getFirst();
        tail=currentTiles.getLast();
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tile getHead() {
        return head;
    }

    public void setHead(Tile head) {
        this.head = head;
    }

    public Tile getTail() {
        return tail;
    }

    public void setTail(Tile tail) {
        this.tail = tail;
    }


}
