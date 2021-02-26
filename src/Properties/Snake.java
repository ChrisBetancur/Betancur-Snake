package Properties;

import java.util.ArrayList;

/**
 * Snake --- Create Snake which contains all properties relating to Snake
 */

public class Snake {

    private int snakeSize;
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

    public ArrayList<Tile> getCurrentTiles() {
        return currentTiles;
    }

    public void setCurrentTiles(ArrayList<Tile> currentTiles) {
        this.currentTiles = currentTiles;
    }
}
