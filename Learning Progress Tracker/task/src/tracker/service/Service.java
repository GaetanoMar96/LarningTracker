package tracker.service;

import tracker.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Service {

    protected static List<Student> studentList = new ArrayList<>();

    public static List<Student> sortStudentsById() {
        return studentList.stream()
                .sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByJava() {
        return studentList.stream()
                .sorted((Comparator.comparing(Student::getJavaPts).reversed()))
                //.sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByDsa() {
        return studentList.stream()
                .sorted((Comparator.comparing(Student::getDsaPts).reversed()))
                //.sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByDb() {
        return studentList.stream()
                .sorted((Comparator.comparing(Student::getDbPts).reversed()))
                //.sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsBySpring() {
        return studentList.stream()
                .sorted((Comparator.comparing(Student::getSpringPts).reversed()))
                //.sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());
    }
}
