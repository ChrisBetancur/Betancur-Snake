package UserInterface.PrimaryWindow;

import GameUtil.Movement;
import Properties.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Properties.Direction.*;

public class GameWindow {

    private final Board board;
    private final Movement movement;
    private final BoardPanel boardPanel;
    private static boolean gameStarted;
    private final Point CENTER_POINT = new Point(775,100);

    private final JFrame gameFrame;
    private JLabel gameScore;
    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,650);

    public GameWindow(Board board) {
        this.board = board;
        this.movement = new Movement(board);

        gameStarted = false;

        this.gameFrame = new JFrame("Snake Game");
        //this.gameFrame.setLocation(CENTER_POINT);
        this.gameFrame.setLocationRelativeTo(null);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);


        //Container con = gameFrame.getContentPane();
        //con.setLayout(new BorderLayout());

        this.boardPanel = new BoardPanel(board);
        this.board.printBoard();

        this.gameFrame.add(this.boardPanel , BorderLayout.SOUTH);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BorderLayout());
        scorePanel.setPreferredSize(new Dimension(600,50));
        scorePanel.setBackground(Color.BLACK);
        this.gameFrame.add(scorePanel, BorderLayout.WEST);

        movement.setWindow(this);
        this.gameFrame.setVisible(true);

        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameScore = new JLabel();
        gameScore.setForeground(Color.WHITE);
        gameScore.setText("Score: " + board.getSnake().getSnakeSize());
        scorePanel.add(gameScore);
        if(!movement.isGameLost()) {
            this.gameFrame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println(gameStarted);
                    gameStarted = true;
                    boardPanel.drawBoard();
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT && movement.getDirection() != LEFT && movement.getDirection() != RIGHT) {
                        movement.setDirection(RIGHT);
                        movement.moveSnake();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT && movement.getDirection() != RIGHT && movement.getDirection() != LEFT) {
                        movement.setDirection(LEFT);
                        movement.moveSnake();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP && movement.getDirection() != DOWN && movement.getDirection() != UP) {
                        movement.setDirection(UP);
                        movement.moveSnake();
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN && movement.getDirection() != UP && movement.getDirection() != DOWN) {
                        movement.setDirection(DOWN);
                        movement.moveSnake();
                    }

                    boardPanel.drawBoard();
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }
        boardPanel.drawBoard();

    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public JLabel getGameScore() {
        return gameScore;
    }

    public void setGameScore(JLabel gameScore) {
        this.gameScore = gameScore;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void cleanUpBoard() {
        boardPanel.drawBoard();
    }
}