package UserInterface.PrimaryWindow;

import Properties.Board;
import Properties.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {

    private List<TilePanel> boardTiles;
    private Board board;
    private final Dimension BOARD_PANEL_DIMENSION = new Dimension(600,600);

    public BoardPanel(Board board) {
        super(new GridLayout(board.getBOARD_ROWS(), board.getBOARD_COLUMNS()));

        this.boardTiles = new ArrayList<>();
        this.board = board;

        //this.setLayout(new BorderLayout());

        for(Tile[] tiles : board.getGameBoard()) {
            for(Tile tile : tiles) {
                TilePanel tilePanel = new TilePanel(this, tile);
                /*if(tile.getRow() == 0 && tile.getCol() == 0) {
                    JLabel scoreLabel = new JLabel("Score: ");
                    tilePanel.add(scoreLabel);
                }*/
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

    public JPanel getBoardPanel() {
        return this;
    }

    public void setScore(JLabel score) {
        this.add(score);
    }
}
