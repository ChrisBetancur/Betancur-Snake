package Properties;

/**
 * Tile --- Creates the the individual tile tha the board is made up of
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (isContainsSnake != tile.isContainsSnake) return false;
        if (isContainsFood != tile.isContainsFood) return false;
        if (row != tile.row) return false;
        return col == tile.col;
    }

    @Override
    public int hashCode() {
        int result = (isContainsSnake ? 1 : 0);
        result = 31 * result + (isContainsFood ? 1 : 0);
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }
}