package tracker.controller;

import tracker.entity.Student;
import tracker.service.Service;

import java.util.List;
import java.util.NoSuchElementException;

public class PointController extends Service {

    public void addPoints(List<String> data) {
        try {
            Student student = studentList.stream()
                    .filter(s -> s.getId().equals(data.get(0)))
                    .findFirst().get();
            data.remove(0);
            student.setPoints(data);
            System.out.println("Points updated.");
        } catch (NoSuchElementException n) {
            System.out.println("No student is found for id=" +data.get(0));
        }
    }

    public void getPoints(String id) {
        Student student = studentList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
        student.getPointsById();
    }

}
