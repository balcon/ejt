package study.unit2.ex05;


import java.util.*;

public class Group<T extends Number> {
    private Subject subject;
    private Map<Student, List<T>> marks;
    public Group(Subject subject) {
        this.subject = subject;
        marks = new HashMap<>();
    }

    public void addStudent(Student student) {
        marks.put(student, new ArrayList<>());
    }

    public void addMarks(Student student, T... marks) {
        Collections.addAll(this.marks.get(student), marks);
    }


    public void showMarks(Student student) {
        if (marks.containsKey(student)) {
            System.out.print("Group "+subject+": ");
            System.out.print(marks.get(student));
            System.out.println(gpa(marks.get(student).toArray()));
        }
    }
/*
    private double gpa(Object[] values){
        double sum=0;
        for (Double value :db) {
            sum+=value;
        }
        return sum/values.length;
    }*/
}
