package tracker;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        checkCommand();
    }

    public static void checkCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Learning Progress Tracker");
        String input;
        while(true) {
            input = sc.nextLine();
            if (input.equals(Command.back.name()))
                System.out.println("Enter 'exit' to exit the program.");
            else if (input.equals(Command.exit.name())) {
                System.out.println("Bye!");
                break;
            }
            else if (input.contains(Command.add.name())) {
                    System.out.println("Enter student credentials or 'back' to return:");
                    checkInput(sc);
                }
            else if (input.isBlank() || input.isEmpty())
                System.out.println("No input.");
            else
                System.out.println("Unknown command!");
        }
        sc.close();
    }

    public static void checkInput(Scanner sc) {
        StudentController controller = new StudentController();
        while(true) {
            String input = sc.nextLine();

            if (input.equals(Command.back.name())) {
                System.out.println("Total " + controller.numStudents()
                        + " students were added");
                break;
            }
            else if (!input.contains(" ") || input.split(" ").length <= 2 || input.isBlank())
                System.out.println("Incorrect credentials");
            else {

                List<String> strings = controller.buildString(input);
                String firstName = strings.get(0);
                String lastName = strings.get(1);
                String email = strings.get(2);

                if (!controller.checkFirstName(firstName))
                    System.out.println("Incorrect first name");
                else if (!controller.checkLastName(lastName))
                    System.out.println("Incorrect last name");
                else if (!controller.checkEmail(email))
                    System.out.println("Incorrect email");
                else
                    controller.addStudent(firstName, lastName, email);
            }
        }
    }
}
