package edu.service;

import edu.model.Student;
import edu.model.Course;
import edu.model.Results;
import java.util.List;

public class ReportService implements Reportable {

    @Override
    public void generateStudentReport(Student student, List<Results> resultList, List<Course> courseList) {
        
       
        System.out.println("\n=========================================");
        System.out.println("         STUDENT ACADEMIC REPORT         ");
        System.out.println("=========================================");
        System.out.println("Student ID      : " + student.getStudentId());
        System.out.println("Registration No : " + student.getRegistrationNumber());
        System.out.println("Index No        : " + student.getIndexNumber());
        System.out.println("Name            : " + student.getName());
        System.out.println("Degree Program  : " + student.getDegreeProgram());
        System.out.println("Year " + student.getCurrentYear() + " Semester " + student.getCurrentSemester());
        System.out.println("-----------------------------------------");
        
        
        System.out.printf("%-12s %-25s %-8s %-7s %-8s %-5s\n", "Course Code", "Course Name", "Credits", "Marks", "Grade", "GP");
        System.out.println("-----------------------------------------");

        double totalCreditWeightedPoints = 0;
        int totalCredits = 0;

       
        for (Results res : resultList) {
            if (res.getStudentId().equals(student.getStudentId())) {
                
               
                String courseName = "Unknown Course";
                int credits = 0;
                
                for (Course c : courseList) {
                    if (c.getCourseCode().equals(res.getCourseCode())) {
                        courseName = c.getCourseName();
                        credits = c.getCredits();
                        break;
                    }
                }

               
                System.out.printf("%-12s %-25s %-8d %-7.1f %-8s %-5.1f\n", 
                        res.getCourseCode(), 
                        courseName, 
                        credits, 
                        res.getMarks(), 
                        res.getGrade(),
                        res.getGradePoint());

                
                totalCreditWeightedPoints += (res.getGradePoint() * credits);
                totalCredits += credits;
            }
        }

        System.out.println("-----------------------------------------");

        
        double semesterGpa = 0.0;
        if (totalCredits > 0) {
            semesterGpa = totalCreditWeightedPoints / totalCredits;
        }

        
        String academicStanding = "Academic Warning";
        if (semesterGpa >= 3.70) {
            academicStanding = "First Class";
        } else if (semesterGpa >= 3.30) {
            academicStanding = "Second Upper";
        } else if (semesterGpa >= 3.00) {
            academicStanding = "Second Lower";
        } else if (semesterGpa >= 2.00) {
            academicStanding = "General Pass";
        }

       
        System.out.printf("Semester GPA     : %.2f\n", semesterGpa);
        System.out.printf("Overall GPA      : %.2f\n", semesterGpa);
        System.out.println("Total Credits    : " + totalCredits);
        System.out.println("Academic Standing: " + academicStanding);
        System.out.println("=========================================");
    }
}