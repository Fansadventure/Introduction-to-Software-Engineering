package de.tum.in.ase.eist;

// TODO 2: Implement the Worker class
public class Worker extends Employee {
    public Worker(String name) {
        super(name);
    }

    // TODO 3: Implement list() for Worker
    @Override
    public void list(int level) {
        this.printName(level);
    }
}
