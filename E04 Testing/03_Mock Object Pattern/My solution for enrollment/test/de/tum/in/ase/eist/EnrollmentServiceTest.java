package de.tum.in.ase.eist;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;

@ExtendWith(EasyMockExtension.class)
public class EnrollmentServiceTest {
    @TestSubject
    private EnrollmentService enrollmentService = new EnrollmentService();
    @Mock
    private Course courseMock;
    @Test
    public void testEnrollStudentSuccessful() {

        // TODO implement the test
        // throw new RuntimeException("not implemented yet");
        Student student = new Student();
        int expectedSize = student.getCourseList().size() + 1;
        expect(courseMock.enroll(student)).andReturn(true);
        replay(courseMock);
        enrollmentService.enroll(student, courseMock);
        Assertions.assertEquals(expectedSize, student.getCourseList().size());
    }
}
