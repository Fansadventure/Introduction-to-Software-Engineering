package de.tum.in.ase.eist;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeeklyTimeSlot extends TimeSlot{
    // TODO: implement according to problem statement
    private DayOfWeek dayOfWeek;
    public WeeklyTimeSlot(DayOfWeek weekday, LocalTime start, LocalTime end) {
        super(start, end);
        this.dayOfWeek = weekday;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
