package tracker.controller;

import tracker.entity.Course;
import tracker.entity.Student;
import tracker.service.Service;

import java.util.List;

public class CourseController extends Service {

    public Course course;

    public void countStatistics() {
        for(Student s : studentList) {
            if (s.getJavaPts() > 0) {
                course.incJavaEnroll();
                course.incJavaSub(s.getJavaSub());
                course.incJavaPoints(s.getJavaPts());
            }
            if (s.getDsaPts() > 0) {
                course.incDsaEnroll();
                course.incJavaSub(s.getDsaSub());
                course.incDsaPoints(s.getDsaPts());
            }
            if (s.getDbPts() > 0) {
                course.incDbEnroll();
                course.incJavaSub(s.getDbSub());
                course.incDbPoints(s.getDbPts());
            }
            if (s.getSpringPts() > 0) {
                course.incSpringEnroll();
                course.incJavaSub(s.getSpringSub());
                course.incSpringPoints(s.getSpringPts());
            }
        }
    }

    public int getMostPop() {
        return Math.max(course.getJavaEnroll(),
                Math.max(course.getDsaEnroll(),
                Math.max(course.getDbEnroll(), course.getSpringEnroll())
                )
        );
    }

    public int getLeastPop() {
        return Math.min(course.getJavaEnroll(),
                Math.min(course.getDsaEnroll(),
                        Math.min(course.getDbEnroll(), course.getSpringEnroll())
                )
        );
    }

    public void printStatistics() {
        System.out.println("Most popular: " + getMostPop() + "\n" +
                "Least popular: n/a\n" +
                "Highest activity: n/a\n" +
                "Lowest activity: n/a\n" +
                "Easiest course: n/a\n" +
                "Hardest course: n/a");
    }

    public void getStatistic(String subject) {
        if (!subject.equals("dsa") && !subject.equals("java") &&
                !subject.equals("databases") && !subject.equals("spring"))
            System.out.println("Unknown course");
        else {
            List<Student> studentListSorted = Service.sortStudentsById();
            switch (subject) {
                case "java":
                    System.out.println("Java");
                    System.out.println("id    points    completed");
                    for(Student s : studentListSorted) {
                        if (s.getJavaPts() > 0)
                            System.out.println(s.getId() + " " +
                                    s.getJavaPts() + "     " +
                                    (float) (s.getJavaPts() * 100 / course.getTotJavaPoints()) + "%");
                        }
                    break;
                case "dsa":
                    System.out.println("DSA");
                    System.out.println("id    points    completed");
                    for(Student s : studentListSorted) {
                        if (s.getDsaPts() > 0)
                            System.out.println(s.getId() + " " +
                                    s.getDsaPts() + "     " +
                                    (float) (s.getDsaPts() * 100 / course.getTotDsaPoints()) + "%");
                    }
                    break;
                case "databases":
                    System.out.println("Databases");
                    System.out.println("id    points    completed");
                    for(Student s : studentListSorted) {
                        if (s.getDbPts() > 0)
                            System.out.println(s.getId() + " " +
                                    s.getDbPts() + "     " +
                                    (float) (s.getDbPts() * 100 / course.getTotDbPoints()) + "%");
                        }
                    break;
                case "spring":
                    System.out.println("Spring");
                    System.out.println("id    points    completed");
                    for(Student s : studentListSorted) {
                        if (s.getSpringPts() > 0)
                            System.out.println(s.getId() + " " +
                                    s.getSpringPts() + "     " +
                                    (float) (s.getSpringPts() * 100 / course.getTotSpringPoints()) + "%");
                        }
                    break;
                }
        }

    }
}
