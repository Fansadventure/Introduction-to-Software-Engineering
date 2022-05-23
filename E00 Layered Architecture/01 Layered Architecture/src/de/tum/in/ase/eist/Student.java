package de.tum.in.ase.eist;

import java.util.HashSet;
import java.util.Set;

public class Student extends Person{
	// TODO: implement according to problem statement
    private String matriculationNumber;
    private int semester;
    private StudyLevel studyLevel;
    private Set<String> knowledge = new HashSet<>();
    private Set<Skill> skills = new HashSet<>();
    public Student(String name, int age, String tumID, String matriculationNumber, StudyLevel sl, int semester){
        super(name, age, tumID);
        this.matriculationNumber = matriculationNumber;
        this.semester = semester;
        this.studyLevel = sl;
    }
   public void acquireKnowledge(String knowledge){
        this.knowledge.add(knowledge);
   }

   public void learnSkill(Skill skill){
       skills.add(skill);
   }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public int getSemester() {
        return semester;
    }

    public StudyLevel getStudyLevel() {
        return studyLevel;
    }

    public Set<String> getKnowledge() {
        return knowledge;
    }
    public Set<Skill> getSkills(){
        return skills;
    }
}
