package model;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String course;
    private int year;


    public Student(int studentId, String name, String email, String course, int year) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
        this.year = year;
    }


    public Student() {}

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }


    @Override
    public String toString() {
        return studentId + " | " + name + " | " + email + " | " + course + " | " + year;
    }
}