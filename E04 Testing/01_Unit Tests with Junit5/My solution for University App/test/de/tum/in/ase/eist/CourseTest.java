package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

	// TODO 1: Test getCourseTitle()
    @Test
    public void testGetCourseTitle() {
        Course myCourse = new Course("EIST2021");
        String expectedCourseTitle = "EIST2021";
        String actualCourseTitle = myCourse.getCourseTitle();
        assertEquals(expectedCourseTitle, actualCourseTitle);
    }

	// TODO 2: Test getNumberOfAttendees()
    @Test
    public void testNoAttendees() {
        Course myCourse = new Course("EIST2021");
        assertEquals(0, myCourse.getNumberOfAttendees());
    }

    @Test
    public void testThreeAttendees() {
        Course myCourse = new Course("EIST2021");
        myCourse.setAttendees(new ArrayList<>());
        for(int i = 0; i < 3; i++) {
            Student s = new Student("Lucky" + i, "Happy" + i,
                    i + ".06.2021", i + "-11", i + "-22");
            myCourse.addAttendee(s);
        }
        assertEquals(3, myCourse.getNumberOfAttendees());
    }

}
