import Engine.GameEngine;
import UserInterface.MainMenuWindow;

import static javafx.application.Application.launch;

/**
 * Game --- The class where the game is run at
 * @author Chris Betancur
 * @author David Alvarez Tamayo
 */
public class Main {
    public static void main(String[] args){

        /*int[][][] arr = new int[3][][];

        int[] arr1 = new int[3];*/

        /**
         * {1,4,3,2,4,2,4,5} 1-D array
         *
         *
         *
         * arr[0]-{41,34,3}
         * arr[1]-{56,3,1}
         * arr[2]-{34,68,6}
         */

        /*for(int i = 0;i<arr1.length;i++){
            arr1[i]=10;
        }

        for(int i = 0;i<arr1.length;i++){
            System.out.print(arr1[i]+",");
        }

        for(int row = 0;row<arr.length;row++){
            arr[row] = new int[5];
            for(int col=0;col< arr[row].length;col++){
                arr[row][col]=5;
            }
        }
        System.out.println();
        System.out.println();
        for(int i = 0;i<arr.length;i++){
            System.out.print("Row "+i+": ");
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+", ");
            }
            System.out.println();
        }*/

        /*Test test = new Test();
        test.setA("Bye");
        String temp=test.getA();

        System.out.println(temp);*/

        //Test test = new Test();
        /**
         * When you initialize a object you use the 'new' keyword
         */
        
        //System.out.println(test.getA());


        //Board board = new Board();
        //board.printBoard();
        //Movement movement = new Movement(board);
        //movement.simulateSnake();
        /*movement.setDirection(LEFT);
        movement.moveSnake();
        movement.moveSnake();
        movement.moveSnake();
        movement.moveSnake();
        movement.setDirection(DOWN);
        movement.moveSnake();
        movement.moveSnake();*/

        //MainMenuWindow mainMenuWindow = new MainMenuWindow();
        //launch();



        GameEngine gameEngine = new GameEngine();
        gameEngine.run();

        //MainMenuWindow mainMenuWindow = new MainMenuWindow();

    }
}
