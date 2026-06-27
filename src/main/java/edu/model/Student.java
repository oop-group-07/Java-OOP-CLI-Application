package edu.model;

public class Student extends Person{
    private String studentId;
    private String registrationNumber;
    private String indexNumber;
    private String name;
    private String degreeProgram;
    private int currentYear;
    private int currentSemester;
    private String email;

    public Student(String studentId, String registrationNumber, String indexNumber, String name, String degreeProgram, int currentYear, int currentSemester, String email) {
        this.studentId = studentId;
        this.registrationNumber = registrationNumber;
        this.indexNumber = indexNumber;
        this.name = name;
        this.degreeProgram = degreeProgram;
        this.currentYear = currentYear;
        this.currentSemester = currentSemester;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getName() {
        return name;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public String getEmail() {
        return email;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegreeProgram(String degreeProgram) {
        this.degreeProgram = degreeProgram;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
