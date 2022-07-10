package tracker;

import tracker.controller.CourseController;
import tracker.controller.StudentController;
import tracker.enums.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static StudentController controller = new StudentController();
    public static CourseController course = new CourseController();

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
            } else if (input.equals(Command.statistics.name())) {
                course.printStatistics();
                while (true) {
                    String subject = sc.nextLine();
                    if (subject.equals("back"))
                        break;
                    course.getStatistic(subject);
                }
            } else if (input.equals(Command.notify.name()))
                course.sendEmail();
            else if (input.contains("students")) {
                    System.out.println("Enter student credentials or 'back' to return:");
                    checkInput(sc);
            } else if (input.equals(Command.list.name()))
                controller.listStudents();
            else if (input.contains(Command.points.name())) {
                System.out.println("Enter an id and points or 'back' to return:");
                while (true) {
                    String inp = sc.nextLine();
                    if (inp.equals("back"))
                        break;
                    List<String> res = Arrays.stream(
                                    inp.split(" "))
                            .collect(Collectors.toList());
                    if (controller.checkData(res))
                        controller.addPoints(res);
                    else
                        System.out.println("Incorrect points format");
                }
            } else if (input.equals(Command.find.name())) {
                System.out.println("Enter an id or 'back' to return:");
                while (true) {
                    String id = sc.nextLine();
                    if (id.equals("back"))
                        break;
                    controller.getPoints(id);
                }
            } else if (input.isBlank() || input.isEmpty())
                System.out.println("No input.");
            else
                System.out.println("Unknown command!");
        }
        sc.close();
    }

    public static void checkInput(Scanner sc) {
        while(true) {
            String input = sc.nextLine();
            if (input.equals(Command.back.name())) {
                System.out.println("Total " + controller.numStudents()
                        + " students were added");
                break;
            } else if (!input.contains(" ") || input.split(" ").length <= 2 || input.isBlank())
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
                else if (controller.existsEmail(email))
                    System.out.println("This email is already taken.");
                else
                    controller.addStudent(firstName, lastName, email);
            }
        }
    }
}
