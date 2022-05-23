
import org.junit.jupiter.api.Test;
import GameObject.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBrick {

    @Test
    public void testEnterSuccess() {
        Brick Hospital = new Brick("red", new Position(6,6));
        Ball patient = new Ball(new Size(20,20),"red");
        Hospital.enter(patient);
        assertEquals(1, Hospital.getPeople().size());
        // infected people will get treated and then the color will change to green
        Hospital.treatment(patient);
        assertEquals("green", patient.getColor());
        assertEquals(0, Hospital.getPeople().size());
    }

    @Test
    public void testEnterFail() {
        // it fails when the color of ball and brick does not match
        Brick brick1 = new Brick("red", new Position(6,6));
        Ball ball1 = new Ball(new Size(20,20),"green");
        brick1.enter(ball1);
        assertEquals(0, brick1.getPeople().size());

        //it fails when the number of balls is greater than the capacity of the brick
        Brick brick2 = new Brick("green", new Position(6,6));   // green bricks has a capacity of 2

        Ball ball21 = new Ball(new Size(20,20),"green");
        Ball ball22 = new Ball(new Size(20,20),"green");
        Ball ball23 = new Ball(new Size(20,20),"green");
        brick2.enter(ball21);
        assertEquals(1, brick2.getPeople().size());
        brick2.enter(ball22);
        assertEquals(2, brick2.getPeople().size());
        brick2.enter(ball23);
        assertEquals(2, brick2.getPeople().size());
    }

    @Test
    public void testLeave() {
        Brick hospital = new Brick("red", new Position(6,6));
        // 5 patients enter hospital and the first 3 of them get treated since there are limited doctors and nurses
        for(int i = 0; i < 5; i++) {
            Ball patient = new Ball(new Size(20,20),"red");
            hospital.enter(patient);
            if(i < 3) {
                hospital.treatment(patient);
            }
        }
        // test whether there are still 2 patients in the hospital:
        assertEquals(2, hospital.getPeople().size());
        assertEquals("red",hospital.getPeople().get(0).getColor());
        assertEquals("red",hospital.getPeople().get(1).getColor());
    }

    @Test
    public void testGetNumberOfBalls() {
        Brick hospital = new Brick("red", new Position(6,6));
        for(int i = 0; i < 4; i++) {
            hospital.enter(new Ball(new Size(10,10),"red"));
        }
        assertEquals(4, hospital.getPeople().size());
    }


    @Test
    public void testCapacityIsFull() {
        Brick hospital = new Brick("red", new Position(6,6));
        for(int i = 0; i < hospital.getCapacity(); i++) {
            hospital.enter(new Ball(new Size(10,10),"red"));
        }
        assertTrue(hospital.capacityIsFull());
        assertEquals("blue", hospital.getColor());
    }


    @Test
    public void testCapacityNotFull() {
        Brick home = new Brick("green", new Position(4,4));
        for(int i = 0; i < home.getCapacity()-1; i++) {
            home.enter(new Ball(new Size(10,10),"green"));
        }
        assertFalse(home.capacityIsFull());
        assertEquals("green", home.getColor());
    }
}
