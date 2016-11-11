package study.unit2.ex05;


import java.util.*;

public class Group<T extends Number> {
    private Subject subject;
    private Map<Student, List<T>> points;

    public Group(Subject subject) {
        this.subject = subject;
        points = new HashMap<>();
    }

    public void addStudent(Student student) {
        points.put(student, new ArrayList<>());
    }

    public void addMarks(Student student, T... points) {
        Collections.addAll(this.points.get(student), points);
    }

    public void showMarks(Student student) {
        if (points.containsKey(student)) {
            System.out.print("Group " + subject + ": ");
            System.out.print(points.get(student));
            System.out.println(" GPA: " + average(points.get(student)));
        }
    }

    private Double average(List<T> points) {
        Double summ = 0D;
        for (T point : points) {
            summ += point.doubleValue();
        }
        summ /= points.size();
        return summ;
    }
}
