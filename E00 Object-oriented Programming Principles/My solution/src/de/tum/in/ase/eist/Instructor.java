package de.tum.in.ase.eist;

public class Instructor extends Person{
	// TODO: implement according to problem statement
    public Instructor(String name, int age, String tumID){
        super(name, age, tumID);
    }
    public void teach(String s){
        this.say("Please learn " + "\"" + s + "\"");
    }

}
