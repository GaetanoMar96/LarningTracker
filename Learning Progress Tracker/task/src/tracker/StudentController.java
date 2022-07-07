package tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentController implements StudentService{

    List<Student> studentList = new ArrayList<>();

    public void addStudent(String name, String lastname, String email) {
        studentList.add(
                new Student(
                        name,
                        lastname,
                        email
                )
        );
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
}
