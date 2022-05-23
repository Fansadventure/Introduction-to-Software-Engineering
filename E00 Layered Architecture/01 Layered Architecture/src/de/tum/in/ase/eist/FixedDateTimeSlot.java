package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.time.LocalTime;

public class FixedDateTimeSlot extends TimeSlot{
    // TODO: implement according to problem statement
    private LocalDate date;
    public FixedDateTimeSlot(LocalDate date, LocalTime start, LocalTime end) {
        super(start, end);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
