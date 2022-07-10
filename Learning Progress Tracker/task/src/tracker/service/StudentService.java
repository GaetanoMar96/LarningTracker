package tracker.service;

import tracker.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

    boolean checkFirstName(String name);

    boolean checkLastName(String lastName);

    boolean checkEmail(String email);

    boolean existsEmail(String email);

    void listStudents();
}
