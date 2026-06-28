package edu.model;

public class Results {
    private String studentID;
    private String courseCode;
    private int academicYear;
    private int semester;
    private double marks;
    private String grade;
    private double gradePoint;

    //default constructor
    public Results(){

    }
    //parameterized constructor
    public Results(String studentID, String courseCode, int academicYear, int semester, double marks, String grade, double gradePoint) {
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.academicYear = academicYear;
        this.semester = semester;
        this.marks = marks;
        this.grade = grade;
        this.gradePoint = gradePoint;
    }
     
     //getters
     public String getStudentID() {
        return studentID;
     }
     public String getCourseCode() {
        return courseCode;
     }
     public int getAcademicYear() {
        return academicYear;
     }
     public int getSemester() {
        return semester;
     }
     public double getMarks() {
            return marks;
    }
     public String getGrade() {
        return grade;
     }
    public double getGradePoint() {
            return gradePoint;
     }
     
    //setters
     public void setStudentID(String studentID) {
        this.studentID = studentID;   
    }
    
     public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
     }
     public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
     }
     public void setSemester(int semester) {
        this.semester = semester;
     }
     public void setMarks(double marks) {
        this.marks = marks;
     }
     public void setGrade(String grade) {
        this.grade = grade;
     }
     public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
     }

     //display results details
     public void displayResultsDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Academic Year: " + academicYear);
        System.out.println("Semester: " + semester);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("Grade Point: " + gradePoint);
     }
    
    //save results details to a file
    @Override
    public String toString() {
        return studentID + "," + courseCode + "," + academicYear + "," + semester + "," + marks + "," + grade + "," + gradePoint;
    }
}