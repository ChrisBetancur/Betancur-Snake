package Engine;

import GameUtil.Movement;
import Properties.Board;
import Properties.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window {

    private Board board;
    private Movement movement;
    private BoardPanel boardPanel;

    private JFrame gameFrame;
    private KeyListener keyListener;
    private boolean endGame;
    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600);

    public Window(Board board) {
        this.board = board;
        this.movement = new Movement(board);

        this.gameFrame = new JFrame("Snake Game");
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);

        this.boardPanel = new BoardPanel(board);
        this.board.printBoard();

        this.gameFrame.add(this.boardPanel , BorderLayout.CENTER);
        this.gameFrame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    movement.setDirection(Direction.RIGHT);
                    movement.moveSnake();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    movement.setDirection(Direction.LEFT);
                    movement.moveSnake();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    movement.setDirection(Direction.UP);
                    movement.moveSnake();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    movement.setDirection(Direction.DOWN);
                    movement.moveSnake();
                }
                boardPanel.drawBoard();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        boardPanel.drawBoard();

        this.gameFrame.setVisible(true);
    }





}