package edu.model;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private int academicYear;
    private int semester;

// Constructor
    public Course(String courseCode, String courseName, int credits, int academicYear, int semester) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.academicYear = academicYear;
        this.semester = semester;
    }

// Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
     public int getAcademicYear() {
        return academicYear;
    }

    public int getSemester() {
        return semester;
    }

// Setters
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
     public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }
     public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course[Course Code=" +courseCode + ",Name=" + courseName +",Credits=" +credits +",Academic Year=" + academicYear +",Semester=" +semester +"]";
    }
}
