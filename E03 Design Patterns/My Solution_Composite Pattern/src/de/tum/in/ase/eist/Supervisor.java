package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

// TODO 1: Implement the Supervisor class
public class Supervisor extends Employee {
    private List<Employee> supervisedEmployees = new ArrayList<>();
    public Supervisor(String name) {
        super(name);
    }

    public void addEmployee(Employee employee) {
        supervisedEmployees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        int  len = supervisedEmployees.size();
        int delete = 0;
        for (int i = 0; i < len; i++) {
            if (employee.getName().equals(supervisedEmployees.get(i).getName())) {
                delete = i;
            }
        }
        supervisedEmployees.remove(delete);
    }
    public List<Employee> getSupervisedEmployees() {
        return supervisedEmployees;
    }

    // TODO 3: Implement list() for Supervisor
    @Override
    public void list(int level) {
        List<Employee> myList = this.getSupervisedEmployees();
        int length = myList.size();
        this.printName(level);
        for (int i = 0; i < length; i++) {
            if (myList.get(i) instanceof Supervisor) {
                myList.get(i).list(level + 1);
            } else {
                myList.get(i).printName(level + 1);
            }
        }
    }
}
