package de.tum.in.ase.eist;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class NavigationServiceTest {

	// TODO make sure to specify the necessary elements for the mock object pattern
    @TestSubject
    private NavigationService ns = new NavigationService();
    @Mock
    private RealTimePositionService realTimePS;
	// TODO implement the 2 tests here
    @Test
    public void testGetInstructions1() {
        PEV pev = new EMoped(2, "MUC2020");
        Destination dest = new Destination(4, 6, "StudentStadt");
        expect(realTimePS.getX(pev)).andReturn(4);
        expect(realTimePS.getY(pev)).andReturn(6);
        expect(realTimePS.getDirection(pev)).andReturn(Direction.EAST);
        replay(realTimePS);
        assertEquals("destination reached", ns.getInstructions(pev, dest));
    }

    @Test
    public void testGetInstructions2() {
        PEV pev = new EMoped(2, "MUC2020");
        Destination dest = new Destination(4, 6, "StudentStadt");
        expect(realTimePS.getX(pev)).andReturn(2);
        expect(realTimePS.getY(pev)).andReturn(6);
        expect(realTimePS.getDirection(pev)).andReturn(Direction.EAST);
        replay(realTimePS);
        assertEquals("continue", ns.getInstructions(pev, dest));
    }
}
