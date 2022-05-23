package de.tum.in.ase.eist;

import java.util.Set;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting{
	// TODO: implement according to problem statement
    private String url;

    public VirtualTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skill, String url){
        super(timeSlot, tutorGroup, skill);
        this.url = url;
    }

    @Override
    public void practice() {
        this.getTutorGroup().getTutor().say("Thank you for joining using " + getUrl() + " today.");
        Set<Student> students =  getTutorGroup().getStudents();
        for(Student s: students){
            s.learnSkill(this.getSkillToPractice());
        }
        this.getTutorGroup().getTutor().say("See you next time!");
    }

    public String getUrl() {
        return url;
    }
}
