package de.tum.in.ase.eist;

import java.time.Duration;
import java.time.LocalTime;

public abstract class TimeSlot {
	// TODO: implement according to problem statement
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlot(LocalTime start, LocalTime end) {
        this.startTime = start;
        this.endTime = end;
    }

    public Duration getDuration(){
        return Duration.between(startTime, endTime);
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

}
