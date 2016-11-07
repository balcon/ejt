package study.unit2.ex05;

import org.junit.Test;

public class Ex05Test {

    @Test
    public void test() {
        final Student jsmith = new Student("John", "Smith");
        final Student pjohnson = new Student("Piter", "Johnson");

        Group<Integer> groupChem = new Group<>(Subject.CHEMISTRY);
        Group<Double> groupMath = new Group<>(Subject.MATH);

        groupChem.addStudent(jsmith);
        groupChem.addStudent(pjohnson);
        groupMath.addStudent(jsmith);

        groupChem.addMarks(jsmith, 3, 4, 5, 3);
        groupChem.addMarks(pjohnson, 2, 3, 4, 5, 2);
        groupMath.addMarks(jsmith, 4.5, 3.75, 2.5, 3.14);

        jsmith.showMarks(groupChem, groupMath);
        System.out.println();
        pjohnson.showMarks(groupChem, groupMath);


    }
}