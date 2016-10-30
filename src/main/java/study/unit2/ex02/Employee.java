package study.unit2.ex02;

import java.util.ArrayList;

class Employee {

    private final String firstName;
    private final String secondName;

    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
