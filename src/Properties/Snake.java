package Properties;

import java.util.ArrayList;

/**
 * Snake --- Create Snake which contains all properties relating to Snake
 */

public class Snake {

    private int snakeSize;
    private Tile head;
    private Tile tail;
    private ArrayList<Tile> currentTiles;

    public Snake(int snakeSize) {
        this.snakeSize = snakeSize;
        this.currentTiles = new ArrayList<>();
    }

    public int getSnakeSize() {
        return snakeSize;
    }

    public void setSnakeSize(int snakeSize) {
        this.snakeSize = snakeSize;
    }

    public void addToSnake(){

    }

    public ArrayList<Tile> getCurrentTiles() {
        return currentTiles;
    }

    public void setCurrentTiles(ArrayList<Tile> currentTiles) {
        this.currentTiles = currentTiles;
        head=currentTiles.get(currentTiles.size()-1);
        tail=currentTiles.get(0);
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
