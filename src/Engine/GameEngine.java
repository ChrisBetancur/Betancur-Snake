package Engine;

import GameUtil.Movement;
import Properties.Board;
import UserInterface.PrimaryWindow.GameWindow;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GameEngine {
    private GameWindow gameWindow;
    private Board board;
    private Movement movement;
    private final int SNAKE_SPEED_MILLISECONDS;
    private final String highScoreLocation = "C:/Users/chris/OneDrive/Desktop/SnakeGame Database/HighScore.txt";

    {
        SNAKE_SPEED_MILLISECONDS = 400;
    }

    private boolean gameEnd;

    public GameEngine() {
        board = new Board();
        movement = new Movement(board);
        gameEnd = false;
    }

    public GameEngine(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        gameEnd = false;
    }

    public void run() {
        initGameWindow();
        loop();
    }

    private void initGameWindow() {
        gameWindow = new GameWindow(board);
    }

    private void loop() {
        //gameWindow = new GameWindow(board);

        while(!gameEnd) {
            //if(delta >= 1) {
            //System.out.println(movement.isGameLost());
            //if(gameWindow.isGameStarted()) {
                try {
                    try {
                        Thread.sleep(SNAKE_SPEED_MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    movement.moveSnake();
                    gameWindow.getBoardPanel().drawBoard();
                    gameWindow.getGameScore().setText("Score: " + board.getSnake().getSnakeSize());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You lost");
                    movement.setGameLost(true);
                    System.exit(0);
                    gameEnd = true;
                }
           //}
        }
    }

    private void appendHighScore() {

    }
}
