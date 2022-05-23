package de.tum.in.ase.eist;

import java.util.Set;

public class LocalTutorGroupMeeting extends TutorGroupMeeting{
    // TODO: implement according to problem statement
    private String room;

    public LocalTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skill, String room){
        super(timeSlot, tutorGroup, skill);
        this.room = room;
    }

    @Override
    public void practice() {
        this.getTutorGroup().getTutor().say("Thank you for coming to " + getRoom() + " today.");
        Set<Student> students =  getTutorGroup().getStudents();
        for(Student s: students){
            s.learnSkill(this.getSkillToPractice());
        }
        this.getTutorGroup().getTutor().say("See you next time!");

    }

    public String getRoom() {
        return room;
    }
}
