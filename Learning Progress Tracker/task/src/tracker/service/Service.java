package tracker.service;

import tracker.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Service {
    protected static List<Student> studentList;

    protected Service() {
        new ArrayList<>();
    }

    public static List<Student> sortStudentsById() {
        return studentList.stream()
                .sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());
    }
}
