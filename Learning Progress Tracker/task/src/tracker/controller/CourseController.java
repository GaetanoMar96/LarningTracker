package tracker.controller;

import tracker.entity.Course;
import tracker.entity.Student;
import tracker.enums.Fields;
import tracker.service.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseController extends Service {

    private Course course;

    private List<String> mostPop;
    private List<String> leastPop;
    private List<String> highAct;
    private List<String> lowAct;

    public CourseController() {
        course = new Course();
    }

    public void countStatistics() {
        for(Student s : studentList) {
            if (s.getJavaPts() > 0) {
                course.incJavaEnroll();
                course.incJavaSub(s.getJavaSub());
                course.incJavaPoints(s.getJavaPts());
            }
            if (s.getDsaPts() > 0) {
                course.incDsaEnroll();
                course.incDsaSub(s.getDsaSub());
                course.incDsaPoints(s.getDsaPts());
            }
            if (s.getDbPts() > 0) {
                course.incDbEnroll();
                course.incDbSub(s.getDbSub());
                course.incDbPoints(s.getDbPts());
            }
            if (s.getSpringPts() > 0) {
                course.incSpringEnroll();
                course.incSpringSub(s.getSpringSub());
                course.incSpringPoints(s.getSpringPts());
            }
        }
    }

    public String getMostPop() {
        if (course.getJavaEnroll() == 0 && course.getDsaEnroll() == 0 && course.getDbEnroll() == 0 && course.getSpringEnroll() == 0)
              return "n/a";
        mostPop = new ArrayList<>();
        Map<String,Integer> enrolled = Map.of("Java", course.getJavaEnroll(),
                "DSA",course.getDsaEnroll(),
                "Databases",course.getDbEnroll(),
                "Spring",course.getSpringEnroll()
        );

        int max = 0;
        for(Map.Entry<String, Integer> entry : enrolled.entrySet()) {
            if (entry.getValue() == max) {
                mostPop.add(entry.getKey());
            } else if (entry.getValue() > max) {
                mostPop.clear();
                mostPop.add(entry.getKey());
                max = entry.getValue();
            }
        }
        return mostPop.toString().replace("[", "").replace("]", "");
    }

    public String getLeastPop() {
        if (course.getJavaEnroll() == 0 && course.getDsaEnroll() == 0 && course.getDbEnroll() == 0 && course.getSpringEnroll() == 0)
            return "n/a";
        if (mostPop.size() == 4)
            return "n/a";
        else {
            leastPop = new ArrayList<>();
            if (!mostPop.contains("Java"))
                leastPop.add("Java");
            if (!mostPop.contains("DSA"))
                leastPop.add("DSA");
            if (!mostPop.contains("Databases"))
                leastPop.add("Databases");
            if (!mostPop.contains("Spring"))
                leastPop.add("Spring");
        }
        return leastPop.toString().replace("[", "").replace("]", "");
    }

    public String getHighSub() {
        if (course.getJavaEnroll() == 0 && course.getDsaEnroll() == 0 && course.getDbEnroll() == 0 && course.getSpringEnroll() == 0)
            return "n/a";
        highAct = new ArrayList<>();
        Map<String,Integer> submission = Map.of("Java", course.getJavaSub(),
                "DSA", course.getDsaSub(),
                "Databases",course.getDbSub(),
                "Spring",course.getSpringSub()
        );
        int max = 0;
        for(Map.Entry<String, Integer> entry : submission.entrySet()) {
            if (entry.getValue() == max) {
                highAct.add(entry.getKey());
            } else if (entry.getValue() > max) {
                highAct.clear();
                highAct.add(entry.getKey());
                max = entry.getValue();
            }
        }
        return highAct.toString().replace("[", "").replace("]", "");
    }

    public String getLessSub() {
        if (course.getJavaEnroll() == 0 && course.getDsaEnroll() == 0 && course.getDbEnroll() == 0 && course.getSpringEnroll() == 0)
            return "n/a";
        if (highAct.size() == 4)
            return "n/a";
        else {
            lowAct = new ArrayList<>();
            if (!highAct.contains("Java"))
                lowAct.add("Java");
            if (!highAct.contains("DSA"))
                lowAct.add("DSA");
            if (!highAct.contains("Databases"))
                lowAct.add("Databases");
            if (!mostPop.contains("Spring"))
                lowAct.add("Spring");
        }
        return lowAct.toString().replace("[", "").replace("]", "");
    }

    public String getHighCourse() {
        if (course.getJavaEnroll() == 0 && course.getDsaEnroll() == 0 && course.getDbEnroll() == 0 && course.getSpringEnroll() == 0)
            return "n/a";
        Map<String,Integer> averaged = Map.of("Java", course.getJavaPoints() / course.getJavaEnroll(),
                "DSA", course.getDsaPoints() / course.getDsaEnroll(),
                "Databases",course.getDbPoints() / course.getDbEnroll(),
                "Spring",course.getSpringPoints() / course.getSpringEnroll()
        );
        StringBuilder course = new StringBuilder();
        int min = 1000;
        for(Map.Entry<String, Integer> entry : averaged.entrySet()) {
            if (entry.getValue() == min) {
                course.append(entry.getKey()).append(" ,");
            } else if (entry.getValue() < min) {
                course = new StringBuilder();
                course.append(entry.getKey());
                min = entry.getValue();
            }
        }
        return course.toString();
    }

    public String getEasyCourse() {
        if (course.getJavaEnroll() == 0 && course.getDsaEnroll() == 0 && course.getDbEnroll() == 0 && course.getSpringEnroll() == 0)
            return "n/a";
        Map<String,Integer> averaged = Map.of("Java", course.getJavaPoints() / course.getJavaEnroll(),
                "DSA", course.getDsaPoints() / course.getDsaEnroll(),
                "Databases",course.getDbPoints() / course.getDbEnroll(),
                "Spring",course.getSpringPoints() / course.getSpringEnroll()
        );
        StringBuilder course = new StringBuilder();
        int max = 0;
        for(Map.Entry<String, Integer> entry : averaged.entrySet()) {
            if (entry.getValue() == max) {
                course.append(entry.getKey()).append(" ,");
            } else if (entry.getValue() > max) {
                course = new StringBuilder();
                course.append(entry.getKey());
                max = entry.getValue();
            }
        }
        return course.toString();
    }

    public void printStatistics() {
        countStatistics();
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        System.out.println("Most popular: " + getMostPop() + "\n" +
                "Least popular: " + getLeastPop() + "\n" +
                "Highest activity: " + getHighSub() + "\n" +
                "Lowest activity: " + getLessSub() + "\n" +
                "Easiest course: " + getEasyCourse() + "\n" +
                "Hardest course: " + getHighCourse() + "\n");
    }

    public void getStatistic(String subject) {
        countStatistics();
        if (!subject.equals("DSA") && !subject.equals("Java") &&
                !subject.equals("Databases") && !subject.equals("Spring"))
            System.out.println("Unknown course.");
        else {
            BigDecimal bd;
            List<Student> studentListSorted;
            switch (subject) {
                case "Java":
                    System.out.println("Java");
                    System.out.println("id    points    completed");
                    studentListSorted = Service.sortStudentsByJava();
                    for(Student s : studentListSorted) {
                        if (s.getJavaPts() > 0) {
                            bd = BigDecimal.valueOf((double) s.getJavaPts() * 100 / (double) course.getTotJavaPoints());
                            System.out.println(s.getId() + " " +
                                    s.getJavaPts() + "       " +
                                    bd.setScale(1, RoundingMode.HALF_UP) + "%");
                        }
                    }
                    break;
                case "DSA":
                    System.out.println("DSA");
                    System.out.println("id    points    completed");
                    studentListSorted = Service.sortStudentsByDsa();
                    for(Student s : studentListSorted) {
                        if (s.getDsaPts() > 0) {
                            bd = BigDecimal.valueOf((double) s.getDsaPts() * 100 / (double) course.getTotDsaPoints());
                            System.out.println(s.getId() + " " +
                                    s.getDsaPts() + "         " +
                                    bd.setScale(1, RoundingMode.HALF_UP) + "%");
                        }
                    }
                    break;
                case "Databases":
                    System.out.println("Databases");
                    System.out.println("id    points    completed");
                    studentListSorted = Service.sortStudentsByDb();
                    for(Student s : studentListSorted) {
                        if (s.getDbPts() > 0) {
                            bd = BigDecimal.valueOf((double) s.getDbPts() * 100 / (double) course.getTotDbPoints());
                            System.out.println(s.getId() + " " +
                                    s.getDbPts() + "         " +
                                    bd.setScale(1, RoundingMode.HALF_UP) + "%");
                        }
                    }
                    break;
                case "Spring":
                    System.out.println("Spring");
                    System.out.println("id    points    completed");
                    studentListSorted = Service.sortStudentsBySpring();
                    for(Student s : studentListSorted) {
                        if (s.getSpringPts() > 0) {
                            bd = BigDecimal.valueOf((double) s.getSpringPts() * 100 / (double) course.getTotSpringPoints());
                            System.out.println(s.getId() + " " +
                                    s.getSpringPts() + "         " +
                                    bd.setScale(1, RoundingMode.HALF_UP) + "%");
                        }
                    }
                    break;
                }
        }
    }

    public void sendEmail() {
        boolean news = false;
        int count = 0;
        String response = "Re: Your Learning Progress";
        String message = "Hello, %s %s! You have accomplished our %s course!\n";
        for(Student s : studentList) {
            if (s.getJavaPts() == course.getTotJavaPoints()) {
                System.out.println("To: " + s.getEmail());
                System.out.println(response);
                System.out.format(message, s.getName(), s.getLastname(), Fields.Java.name());
                news = true;
            }
            if (s.getDsaPts() == course.getTotDsaPoints()) {
                System.out.println("To: " + s.getEmail());
                System.out.println(response);
                System.out.format(message, s.getName(), s.getLastname(), Fields.DSA.name());
                news = true;
            }
            if (s.getDbPts() == course.getTotDbPoints()) {
                System.out.println("To: " + s.getEmail());
                System.out.println(response);
                System.out.format(message, s.getName(), s.getLastname(), Fields.Databases.name());
                news = true;
            }
            if (s.getSpringPts() == course.getTotSpringPoints()) {
                System.out.println("To: " + s.getEmail());
                System.out.println(response);
                System.out.format(message, s.getName(), s.getLastname(), Fields.Spring.name());
                news = true;
            }
            if (news) {
                count += 1;
                news = false;
            }
        }
        System.out.format("Total %d students have been notified.", count);
    }
}
