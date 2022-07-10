package tracker.entity;

public class Course {

    private final int totJavaPoints = 600;
    private final int totDsaPoints = 400;
    private final int totDbPoints = 480;
    private final int totSpringPoints = 550;

    private int javaEnroll = 0;
    private int dsaEnroll = 0;
    private int dbEnroll = 0;
    private int springEnroll = 0;

    private int javaSub = 0;
    private int dsaSub = 0;
    private int dbSub = 0;
    private int springSub = 0;

    private int javaPoints = 0;
    private int dsaPoints = 0;
    private int dbPoints = 0;
    private int springPoints = 0;

    public int getJavaEnroll() {return this.javaEnroll;}

    public void incJavaEnroll() {this.javaEnroll += 1;}

    public int getDsaEnroll() {return this.dsaEnroll;}

    public void incDsaEnroll() {
        this.dsaEnroll += 1;
    }

    public int getDbEnroll() {return this.dbEnroll;}

    public void incDbEnroll() {
        this.dbEnroll += 1;
    }

    public int getSpringEnroll() {return this.springEnroll;}

    public void incSpringEnroll() {
        this.springEnroll += 1;
    }

    public void incJavaSub(int subs) {this.javaSub += subs;}

    public void incDsaSub(int subs) {
        this.dsaSub += subs;
    }

    public void incDbSub(int subs) {this.dbSub += subs;}

    public void incSpringSub(int subs) {
        this.springSub += subs;
    }

    public void incJavaPoints(int points) {this.javaPoints += points;}

    public void incDsaPoints(int points) {
        this.dsaPoints += points;
    }

    public void incDbPoints(int points) {
        this.dbPoints += points;
    }

    public void incSpringPoints(int points) {
        this.springPoints += points;
    }

    public int getTotJavaPoints() {return totJavaPoints;}
    public int getTotDsaPoints() {return totDsaPoints;}
    public int getTotDbPoints() {return totDbPoints;}
    public int getTotSpringPoints() {return totSpringPoints;}
}
