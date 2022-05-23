package GameObject;

import java.util.ArrayList;
import java.util.List;

public class Brick extends GameObject {
    private int capacity; // the max number of patients
    private List<Ball> patients = new ArrayList<>();
    private static final int RED_CAPACITY = 5;
    private static final int GREEN_CAPACITY = 2;
    private static final int BRICK_WIDTH = 4;
    private static final int BRICK_HEIGHT = 2;

    public Brick(String color, Position position) {
        this.setPosition(position);
        this.setColor(color);
        this.setSize(new Size(BRICK_WIDTH,BRICK_HEIGHT));
        if (color.equals("red")) {
            this.capacity = RED_CAPACITY;
        }
        else if (color.equals("green")) {
            this.capacity = GREEN_CAPACITY;
        }
    }

    public void enter(Ball ball){
        if(ball.getColor().equals(this.getColor()) && patients.size() < this.getCapacity()) {
            patients.add(ball);
        }
    }

    public void treatment(Ball ball) {
        if(ball.getColor().equals("red")) {
            ball.setColor("green");
        }
        leave(ball);
    }

    public void leave(Ball ball) {
        if(ball.getColor().equals("green")) {
            patients.remove(ball);
        }
    }

    public int getNumberOfPatients() {
        return patients.size();
    }

    public int getCapacity() {
        return capacity;
    }

    // when the hospital is full of patients, its color wil change to blue, otherwise it remains red
    public boolean capacityIsFull() {
        if(patients.size() == this.capacity) {
            this.setColor("blue");
        }
        return patients.size() == this.capacity;
    }

    public List<Ball> getPeople() {
        return patients;
    }
    
}
