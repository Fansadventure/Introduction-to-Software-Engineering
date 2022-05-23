import GameBoard.GameBoard;
import GameObject.Ball;
import GameObject.Size;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameBoard {

    @Test
    public void testStartGame() {
        Size size = new Size(20,20);
        GameBoard gameBoard = new GameBoard(size);
        gameBoard.startGame();
        assertTrue(gameBoard.isRunning());
    }

    @Test
    public void testStopGame() {
        Size size = new Size(20,20);
        GameBoard gameBoard = new GameBoard(size);
        gameBoard.stopGame();
        assertFalse(gameBoard.isRunning());
    }

    @Test
    public void testGetSize() {
        Size gameBoardSize= new Size(20,20);
        GameBoard gameBoard = new GameBoard(gameBoardSize);
        assertEquals(20, gameBoard.getSize().getWidth());
        assertEquals(20, gameBoard.getSize().getHeight());
    }

    @Test
    public void testCreateBall() {
        Size size = new Size(20,20);
        GameBoard gameBoard = new GameBoard(size);
        assertEquals(10, gameBoard.getBalls().size());

        int countRed = 0;
        int countGreen = 0;
        List<Ball> balls = gameBoard.getBalls();
        for(int i = 0; i < gameBoard.getNumberOfBalls(); i++) {

            if(balls.get(i).getColor().equals("red")) {
                countRed ++;
            }
            if(balls.get(i).getColor().equals("green")) {
                countGreen ++;
            }
        }
        assertEquals(balls.size()/2, countRed);
        assertEquals(balls.size() - balls.size()/2, countGreen);
    }

    @Test
    public void testDeleteBall() {
        Size size = new Size(10,10);
        
        GameBoard gameBoard = new GameBoard(size);
        List<Ball> balls = gameBoard.getBalls();
        Ball ball = balls.get(1);
        gameBoard.deleteBall(ball);
        assertEquals(9, gameBoard.getBalls().size());

        int countRed = 0;
        int countGreen = 0;
        for(int i = 0; i < gameBoard.getNumberOfBalls(); i++) {

            if(balls.get(i).getColor().equals("red")) {
                countRed ++;
            }
            if(balls.get(i).getColor().equals("green")) {
                countGreen ++;
            }
        }
        assertEquals(gameBoard.getBalls().size()/2 + 1, countRed);
        assertEquals(balls.size()/2, countGreen);
    }
}
