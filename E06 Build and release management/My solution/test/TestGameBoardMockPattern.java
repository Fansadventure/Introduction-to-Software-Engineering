import GameBoard.*;
import GameObject.*;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
public class TestGameBoardMockPattern {
    @TestSubject
    private GameBoard gameBoard= new GameBoard(new Size(20, 20));
    @Mock
    private CollisionStrategy collisionType;
    @Test
    public void testCollideWithRedBrick(){
        // setUp attributes,  expected type = "CollideWithRedBrick"
        expect(collisionType.getCollisionType()).andReturn("CollideWithRedBrick");
        replay(collisionType);

        // test:
        gameBoard.collide();
        assertEquals(1, gameBoard.getBricks().get(0).getNumberOfPatients());
        assertEquals(9, gameBoard.getNumberOfBalls());
    }
    @Test
    public void TestCollideWithRedBall(){
        // this test the case when a green ball collides with a red one and it turns red
        // setUp attributes: expected type = "CollideWithRedBall"
        expect(collisionType.getCollisionType()).andReturn("CollideWithRedBall");
        replay(collisionType);

        // test:
        gameBoard.collide();
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
        assertEquals(6, countRed);
        assertEquals(4, countGreen);
    }
}
