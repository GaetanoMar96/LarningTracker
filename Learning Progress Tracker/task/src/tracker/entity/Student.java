package tracker.entity;

import java.util.List;
import java.util.Map;

public class Student {

    private String id;
    private String name;
    private String lastName;
    private String email;

    private Map<String, Point> pointsMap;
    private final Point point = new Point();

    public Student() {}

    public Student(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoints(List<String> data) {
        point.setJavaPoint(Integer.parseInt(data.get(0)));
        point.setDsaPoint(Integer.parseInt(data.get(1)));
        point.setDbPoint(Integer.parseInt(data.get(2)));
        point.setSpringPoint(Integer.parseInt(data.get(3)));
    }

    public void getPointsById() {
        System.out.println(getId() + " points: " +
                point.getJavaPoint() + " " +
                point.getDsaPoint() + " " +
                point.getDbPoint() + " " +
                point.getSpringPoint());
    }
}
