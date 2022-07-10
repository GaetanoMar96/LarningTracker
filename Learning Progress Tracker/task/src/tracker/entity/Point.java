package tracker.entity;

public class Point {

    private int javaPoints = 0;
    private int dsaPoints = 0;
    private int dbPoints = 0;
    private int springPoints = 0;

    private int javaSub = 0;
    private int dsaSub = 0;
    private int dbSub = 0;
    private int springSub = 0;

    public Point() {}

    public String getJavaPoint() {
        String java = "Java";
        return java +"="+ this.javaPoints+";";
    }

    public int getJavaPoints() {
        return this.javaPoints;
    }

    public void setJavaPoint(int point) {this.javaPoints += point;}

    public int getJavaSub() {return this.javaSub;}

    public void setJavaSub() {this.javaSub += 1;}

    public String getDsaPoint() {
        String dsa = "DSA";
        return dsa +"="+ this.dsaPoints+";";
    }

    public int getDsaPoints() {
        return this.dsaPoints;
    }

    public void setDsaPoint(int point) {this.dsaPoints += point;}

    public int getDsaSub() {return this.dsaSub;}

    public void setDsaSub() {this.dsaSub += 1;}

    public String getDbPoint() {
        String database = "Databases";
        return database +"="+ this.dbPoints+";";
    }

    public int getDbPoints() {
        return this.dbPoints;
    }

    public void setDbPoint(int point) {this.dbPoints += point;}

    public int getDbSub() {return this.dbSub;}

    public void setDbSub() {this.dbSub += 1;}

    public String getSpringPoint() {
        String spring = "Spring";
        return spring +"="+ this.springPoints;
    }

    public int getSpringPoints() {
        return this.springPoints;
    }

    public void setSpringPoint(int point) {this.springPoints += point;}

    public int getSpringSub() {return this.springSub;}

    public void setSpringSub() {this.springSub += 1;}

}
