package Engine;

import Properties.Board;
import Properties.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {

    private List<TilePanel> boardTiles;
    private Board board;
    private final Dimension BOARD_PANEL_DIMENSION = new Dimension(400,300);

    public BoardPanel(Board board) {
        super(new GridLayout(board.getBOARD_ROWS(), board.getBOARD_COLUMNS()));

        this.boardTiles = new ArrayList<>();
        this.board = board;

        for(Tile[] tiles : board.getGameBoard()) {
            for(Tile tile : tiles) {
                TilePanel tilePanel = new TilePanel(this, tile);
                boardTiles.add(tilePanel);
                add(tilePanel);
            }
        }
        setPreferredSize(BOARD_PANEL_DIMENSION);
        validate();
    }

    public void drawBoard() {
        removeAll();
        for(TilePanel tilePanel : boardTiles) {
            tilePanel.drawTile();
            add(tilePanel);
        }
        validate();
        repaint();
    }
}
