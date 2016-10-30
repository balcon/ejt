package study.unit2.ex05;


import java.util.*;

public class Group<T extends Number> {

    public static Group<? extends Number> newGroup(Subject subject) {
        if (subject.isDouble()) return new Group<Double>(subject);
        else return new Group<Integer>(subject);
    }

    private final Subject subject;
    private final Map<Student, List<T>> marks = new HashMap<>();

    public Group(Subject subject) {
        this.subject = subject;
    }

    public Group<T> addStudent(Student student) {
        marks.put(student, new ArrayList<>());
        return this;
    }

    public Group<T> addMark(Student student, T mark) {
        marks.get(student).addAll(Arrays.asList(mark));
        return this;
    }

}
