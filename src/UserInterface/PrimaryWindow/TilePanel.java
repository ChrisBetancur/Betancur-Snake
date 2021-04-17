package UserInterface.PrimaryWindow;

import Properties.Tile;
import UserInterface.PrimaryWindow.BoardPanel;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {

    private final Tile tile;
    private BoardPanel boardPanel;
    private Color color;

    private final Color SNAKE_TILE = Color.GREEN;
    private final Color FOOD_TILE = Color.RED;
    private final Color emptyTile = Color.BLACK;

    private final Dimension TILE_PANEL_DIMENSION = new Dimension(10,10);

    public TilePanel(BoardPanel boardPanel, Tile tile) {
        super(new GridBagLayout());

        setPreferredSize(TILE_PANEL_DIMENSION);
        this.boardPanel = boardPanel;
        this.tile = tile;
        this.assignColor();
    }

    private void assignColor() {
        if(tile.isContainsSnake()) {
            color = SNAKE_TILE;
            setBackground(color);
            return;
        }
        if(tile.isContainsFood()) {
            color = FOOD_TILE;
            setBackground(color);
            return;
        }
        color = emptyTile;
        setBackground(color);
    }

    public void drawTile() {
        assignColor();
        validate();
        repaint();
    }


}
