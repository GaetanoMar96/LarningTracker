package tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {

    StudentController controller = new StudentController();

    @Test
    void checkName() {
        String name = "J.";
        assertTrue(controller.checkFirstName(name));
    }

    @Test
    void checkEmail() {
        String email = "jane@domain.com";
        assertTrue(controller.checkEmail(email));
    }

    @Test
    void validateString() {
        String name = "Robert Jemison Van de Graaff robertvdgraaff@mit.edu";
        List<String> correct =
                Arrays.asList("Robert",
                        "Jemison Van de Graaff",
                        "robertvdgraaff@mit.edu");
        List<String> output = controller.buildString(name);
        assertEquals(correct, output);
    }
}
