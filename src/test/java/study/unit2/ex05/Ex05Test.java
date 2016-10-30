package study.unit2.ex05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Ex05Test {

    @Test
    public void test() {

        final Student jsmith = new Student("John", "Smith");
        final Student pjohnson = new Student("Piter", "Johnson");
        final Student hsimpson = new Student("Homer","Simpson");

        List<Group<? extends Number>> groups=new ArrayList<>();
        groups.add(Group.newGroup(Subject.MATH));
        groups.add(Group.newGroup(Subject.CHEMESTRY));
        groups.add(Group.newGroup(Subject.PHYSIC));

        groups.get(0).addStudent(jsmith).addStudent(pjohnson).addStudent(hsimpson);
        groups.get(1).addStudent(jsmith).addStudent(pjohnson);
        groups.get(2).addStudent(jsmith);

//        groups.get(0)
        new Group(Subject.MATH)
                .addMark(jsmith, 4.5)
                .addMark(pjohnson,4.2)
                .addMark(hsimpson, 3.1);
//        groups.get(1).addMark(jsmith,8);

        






    }
}