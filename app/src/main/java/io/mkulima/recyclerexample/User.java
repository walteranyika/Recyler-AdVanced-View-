package io.mkulima.recyclerexample;
public class User {

    private  String name;
    private String course;
    private String campus;
    private boolean complete;

    public User(String name, String course, String campus, boolean complete) {
        this.name = name;
        this.course = course;
        this.campus = campus;
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
