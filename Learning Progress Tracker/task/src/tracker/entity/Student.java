package tracker.entity;

import java.util.List;
import java.util.Map;

public class Student {

    private String id;
    private String name;
    private String lastName;
    private String email;

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
        int javaPoints = Integer.parseInt(data.get(0));
        int dsaPoints = Integer.parseInt(data.get(1));
        int dbPoints = Integer.parseInt(data.get(2));
        int springPoints = Integer.parseInt(data.get(3));
        if (javaPoints > 0) {
            point.setJavaPoint(javaPoints);
            point.setJavaSub();
        }
        if (dsaPoints > 0) {
            point.setDsaPoint(dsaPoints);
            point.setDsaSub();
        }
        if (dbPoints > 0) {
            point.setDbPoint(dbPoints);
            point.setDbSub();
        }
        if (springPoints > 0) {
            point.setSpringPoint(springPoints);
            point.setSpringSub();
        }
    }

    public void getPointsById() {
        System.out.println(getId() + " points: " +
                point.getJavaPoint() + " " +
                point.getDsaPoint() + " " +
                point.getDbPoint() + " " +
                point.getSpringPoint());
    }

    public int getJavaPts() {return point.getJavaPoints();}

    public int getJavaSub() {return point.getJavaSub();}

    public int getDsaPts() {return point.getDsaPoints();}

    public int getDsaSub() {return point.getDsaSub();}

    public int getDbPts() {return point.getDbPoints();}

    public int getDbSub() {return point.getDbSub();}

    public int getSpringPts() {return point.getSpringPoints();}

    public int getSpringSub() {return point.getSpringSub();}
}
