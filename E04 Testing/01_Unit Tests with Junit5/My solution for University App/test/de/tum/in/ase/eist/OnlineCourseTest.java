package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineCourseTest {

	// TODO 3: Test setOnlineCourseUrl()
    @Test
    public void testSetOnlineCourseUrlWithValidUrl() throws MalformedURLException {
        OnlineCourse online = new OnlineCourse("EIST2021");
        online.setOnlineCourseUrl("http://example.com");
        assertEquals("http://example.com", online.getOnlineCourseUrl().toString());
    }

    @Test ()
    public void testSetOnlineCourseUrlWithInvalidUrl() {
        OnlineCourse online = new OnlineCourse("EIST2021");
        try {
            online.setOnlineCourseUrl("hp://example.com");
            assertNull(online.getOnlineCourseUrl());
            fail();
        } catch (MalformedURLException e) {
        }
    }
}
