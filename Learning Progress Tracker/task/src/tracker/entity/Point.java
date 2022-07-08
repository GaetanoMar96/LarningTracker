package tracker.entity;

public class Point {

    private int javaPoints = 0;
    private int dsaPoints = 0;
    private int dbPoints = 0;
    private int springPoints = 0;

    public Point() {}

    public String getJavaPoint() {
        String java = "Java";
        return java +"="+ this.javaPoints+";";
    }

    public void setJavaPoint(int point) {this.javaPoints += point;}

    public String getDsaPoint() {
        String dsa = "DSA";
        return dsa +"="+ this.dsaPoints+";";
    }

    public void setDsaPoint(int point) {this.dsaPoints += point;}

    public String getDbPoint() {
        String database = "Databases";
        return database +"="+ this.dbPoints+";";
    }

    public void setDbPoint(int point) {this.dbPoints += point;}

    public String getSpringPoint() {
        String spring = "Spring";
        return spring +"="+ this.springPoints;
    }

    public void setSpringPoint(int point) {this.springPoints += point;}

}
