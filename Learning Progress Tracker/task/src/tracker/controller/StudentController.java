package tracker.controller;

import tracker.entity.Student;
import tracker.service.Service;
import tracker.service.StudentService;

import java.util.*;
import java.util.stream.Collectors;

public class StudentController extends Service implements StudentService {

    private int count_id = 10000;

    public void addStudent(String name, String lastname, String email) {
        Student student = new Student(name, lastname, email);
        student.setId(Integer.toString(count_id));
        studentList.add(student);
        count_id += 1;
        System.out.println("The student has been added.");
    }

    public int numStudents() { return studentList.size(); }

    public List<String> buildString(String input) {
        List<String> strings = new ArrayList<>();
        String firstname = input.split(" ")[0];
        String email = input.split(" ")[input.split(" ").length - 1];
        String lastname = String.join(" ", Arrays.stream(input.split(" "))
                        .collect(Collectors.toList())
                        .subList(1, input.split(" ").length - 1))
                        .trim();

        strings.add(firstname);
        strings.add(lastname);
        strings.add(email);
        return strings;
    }

    @Override
    public boolean checkFirstName(String firstName) {
        if(firstName.length() < 2)
            return false;
        return firstName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }

    @Override
    public boolean checkLastName(String lastName) {
        final String lastnamePattern = "[a-zA-z]+([ '-][a-zA-Z]+)*";
        if(lastName.length() < 2)
            return false;
        return lastName.matches(lastnamePattern);
    }

    @Override
    public boolean checkEmail(String email) {
        final String emailPattern = "^[^@]+@[^@]+\\.[^@]+$";
        return email.matches(emailPattern);
    }

    @Override
    public boolean existsEmail(String email) {
        return studentList.stream()
                .anyMatch(s -> s.getEmail().equals(email));
    }

    @Override
    public void listStudents() {
        List<Student> students = studentList.stream()
                .sorted((Comparator.comparing(Student::getId)))
                .collect(Collectors.toList());

        if (students.isEmpty())
            System.out.println("No students found");
        else {
            System.out.println("Students:");
            for(Student student : students)
                System.out.println(student.getId());
        }
    }

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

    public boolean checkData(List<String> data) {
        if (data.size() != 5)
            return false;
        for (int i = 1; i < data.size(); i++) {
            if(!data.get(i).matches("[0-9]|10"))
                return false;
        }
        return true;
    }
}
