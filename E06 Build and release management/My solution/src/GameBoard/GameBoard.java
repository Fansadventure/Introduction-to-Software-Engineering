package GameBoard;

import GameObject.Ball;
import GameObject.Brick;
import GameObject.Position;
import GameObject.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private static final int NUMBER_OF_PATIENTS = 10;
    private final ArrayList<Ball> patients = new ArrayList<>();
    private final ArrayList<Brick> hospitals = new ArrayList<>();
    private boolean running;
    private final Size size;
    private CollisionStrategy collisionStrategy;

    private static final int DIVIDE_FOUR = 4;
    private static final int MULTIPLY_THREE = 3;
    private static final int X_COORDINATE = 8;
    private static final int Y_COORDINATE = 6;

    public Size getSize() {
        return size;
    }

    public GameBoard(Size size) {
        this.size = size;
        this.createBalls();
        this.createBricks();
    }

    public void startGame() {
        running = true;
    }
    public void stopGame() {
        running = false;
    }

    public void createBalls() {
        for(int i = 0; i < NUMBER_OF_PATIENTS; i++) {
            if(i < NUMBER_OF_PATIENTS / 2){
                Ball ball = new Ball(getSize(), "green");
                int lowerY = this.getSize().getHeight() / DIVIDE_FOUR;
                int upperY = lowerY * MULTIPLY_THREE;
                Position newPosition = this.createRandomPosition(getSize().getWidth(),lowerY, upperY);
                ball.setPosition(newPosition);
                patients.add(ball);
            } else {
                patients.add(new Ball(getSize(), "red"));
            }
        }
    }

    public void createBricks() {
        Brick brick = new Brick("red", new Position(X_COORDINATE, Y_COORDINATE));
        hospitals.add(brick);
    }

    private Position createRandomPosition(int x, int lowerY, int upperY) {
        int coordinateX = new Random().nextInt(x);
        int coordinateY = new Random().nextInt(upperY - lowerY) + lowerY;
        return new Position(coordinateX, coordinateY);
    }

    public List<Ball> getBalls() {
        return patients;
    }

    public List<Brick> getBricks() {
        return hospitals;
    }

    public boolean isRunning() {
        return running;
    }

    public void deleteBall(Ball ball) {
        patients.remove(ball);
    }

    public int getNumberOfBalls() {
        return getBalls().size();
    }

/*  collide() is always from the perspective of the chosen ball that is moving on the screen
*  with other game objects, for instance, a chosen red ball collides with a red brick, or a chosen
* green ball collides with a red ball*/
    public void collide() {
        String collisionType = collisionStrategy.getCollisionType();
        if(collisionType.equals("CollideWithRedBrick")) {
            Ball patient = patients.get(getNumberOfBalls() - 1);
            Brick Hospital = hospitals.get(0);
            Hospital.enter(patient);
            this.deleteBall(patient);
        }

        if(collisionType.equals("CollideWithRedBall")) {
            patients.get(0).setColor("red");
        }
    }
}
