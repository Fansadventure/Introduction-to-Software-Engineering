package de.tum.in.ase.eist;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
public class DiscussionTest {

    // TODO implement the tests
    @TestSubject
    private Discussion discussion = new Discussion();
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;

    @Test
    public void testComment() {
        int expected = discussion.getNumberOfComments() + 1;
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        assertTrue(discussion.addComment(commentMock));
        int actual = discussion.getNumberOfComments();
        assertEquals(expected, actual);
    }

    @Test
    public void testCommentIfSavingFails() {
        int expected = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        assertFalse(discussion.addComment(commentMock));
        int actual = discussion.getNumberOfComments();
        assertEquals(expected, actual);
    }

    @Test
    public void testStartCourseDiscussion() {
        Person student = new Student("Ivan", "Chan", LocalDate.parse("2001-06-06"), "Informatik", "Finance");
        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);
        assertTrue(discussion.startCourseDiscussion(courseMock, student, "EasyMock tests"));
        assertEquals(courseMock, discussion.getCourse());
        assertEquals("EasyMock tests", discussion.getTopic());
    }

}
