package Engine;

import Properties.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TilePanel extends JPanel {

    private final Tile tile;
    private BoardPanel boardPanel;
    private Color color;

    private final Color snakeTile = Color.GREEN;
    private final Color foodTile = Color.RED;
    private final Color emptyTile = Color.BLACK;

    private final Dimension TILE_PANEL_DIMENSION = new Dimension(5,5);

    public TilePanel(BoardPanel boardPanel, Tile tile) {
        super(new GridBagLayout());

        this.boardPanel = boardPanel;
        this.tile = tile;
        this.assignColor();
    }

    private void assignColor() {
        if(tile.isContainsSnake()) {
            color = snakeTile;
            setBackground(color);
            return;
        }
        if(tile.isContainsFood()) {
            color = foodTile;
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
