package tracker.service;

public interface StudentService {

    boolean checkFirstName(String name);

    boolean checkLastName(String lastName);

    boolean checkEmail(String email);

    boolean existsEmail(String email);

    void listStudents();
}
