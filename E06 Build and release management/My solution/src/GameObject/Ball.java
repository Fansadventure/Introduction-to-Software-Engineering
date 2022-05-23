package GameObject;

import java.util.concurrent.ThreadLocalRandom;

public class Ball extends GameObject {
    private static final int MAX_ANGLE = 360;
    private static final int HALF_ANGLE = MAX_ANGLE / 2;

    private static final int DEFAULT_BALL_WIDTH = 1;
    private static final int DEFAULT_BALL_HEIGHT = 1;
    private static final int SPEED = 5;

    private int direction;

    public Ball(Size GameBoardSize, String color) {
        this.setColor(color);
        this.setRandomPosition(GameBoardSize);
        this.setRandomDirection();
        this.setSize(new Size(DEFAULT_BALL_WIDTH, DEFAULT_BALL_HEIGHT));
    }

    public static int getMaxAngle() {
        return MAX_ANGLE;
    }


    protected void setRandomPosition(Size GameBoardSize) {
        int carX = calculateRandomInt(0, GameBoardSize.getWidth() - getSize().getWidth());
        int carY = calculateRandomInt(0, GameBoardSize.getHeight() - getSize().getHeight());
        this.setPosition(new Position(carX, carY));
    }

    protected static double calculateRandomDouble(double minValue, double maxValue) {
        return ThreadLocalRandom.current().nextDouble(minValue, maxValue);
    }

    protected void setRandomDirection() {
        this.direction = calculateRandomInt(0, MAX_ANGLE);
    }

    protected static int calculateRandomInt(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }

    public void move(Size GameBoardSize) {
        if (this.getColor().equals("green")) {
            return;
        }
        double maxX = GameBoardSize.getWidth();
        double maxY = GameBoardSize.getHeight();
        // calculate delta between old coordinates and new ones based on speed and direction
        double deltaX = SPEED * Math.sin(Math.toRadians(this.direction));
        double deltaY = SPEED * Math.cos(Math.toRadians(this.direction));
        double newX = this.getPosition().getX() + deltaX;
        double newY = this.getPosition().getY() + deltaY;
        // calculate position if one the boarder of the GameBoard
        if (newX < 0) {
            newX = -newX;
            this.direction = MAX_ANGLE - this.direction;
        } else if (newX + this.getSize().getWidth() > maxX) {
            newX = 2 * maxX - newX - 2 * this.getSize().getWidth();
            this.direction = MAX_ANGLE - this.direction;
        }

        if (newY < 0) {
            newY = -newY;
            this.direction = HALF_ANGLE - this.direction;
            if (this.direction < 0) {
                this.direction = MAX_ANGLE + this.direction;
            }
        } else if (newY + this.getSize().getHeight() > maxY) {
            newY = 2 * maxY - newY - 2 * this.getSize().getHeight();
            this.direction = HALF_ANGLE - this.direction;
            if (this.direction < 0) {
                this.direction = MAX_ANGLE + this.direction;
            }
        }
        // change to new position
        this.setPosition(new Position(newX, newY));
    }
}
