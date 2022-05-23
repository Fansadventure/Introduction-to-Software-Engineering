package de.tum.in.ase.eist;

public class Person {
	// TODO: implement according to problem statement
    private String name;
    private int age;
    private String tumId;
    public Person(String name, int age, String tumID){
        this.name = name;
        this.age = age;
        this.tumId = tumID;
    }
    public void say(String s){
        System.out.println(getName() + " said: " + s);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTumId() {
        return tumId;
    }
}
