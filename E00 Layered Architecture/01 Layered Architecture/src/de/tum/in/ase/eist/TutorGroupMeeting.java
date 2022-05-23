package de.tum.in.ase.eist;

public abstract class TutorGroupMeeting {
	// TODO: implement according to problem statement
    private TutorGroup tutorGroup;
    private FixedDateTimeSlot timeSlot;
    private Skill skillToPractice;

    public TutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skill){
        this.tutorGroup = tutorGroup;
        this.timeSlot = timeSlot;
        this.skillToPractice = skill;
    }

    public abstract void practice();

    public TutorGroup getTutorGroup() {
        return tutorGroup;
    }

    public FixedDateTimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Skill getSkillToPractice() {
        return skillToPractice;
    }
}
