package Properties;

public class Tile {

    private boolean isContainsSnake;
    private boolean isContainsFood;

    private int row;
    private int col;

    public Tile(){

    }

    public Tile(boolean isContainsSnake, boolean isContainsFood, int row, int col) {
        this.isContainsSnake = isContainsSnake;
        this.isContainsFood = isContainsFood;
        this.row = row;
        this.col = col;
    }

    public boolean isContainsSnake() {
        return isContainsSnake;
    }

    public void setContainsSnake(boolean containsSnake) {
        isContainsSnake = containsSnake;
    }

    public boolean isContainsFood() {
        return isContainsFood;
    }

    public void setContainsFood(boolean containsFood) {
        isContainsFood = containsFood;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}