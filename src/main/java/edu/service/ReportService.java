package edu.service;

import java.util.ArrayList;
import java.util.Scanner;

import edu.model.Course;
import edu.model.Results;
import edu.model.Student;
import edu.repository.CourseRepository;
import edu.repository.ResultRepo;
import edu.repository.StudentRepo;
import edu.model.GPACalculator; // Aluth import eka

public class ReportService {
    private StudentRepo studentRepo;
    private ResultRepo resultRepo;
    private CourseRepository courseRepo;
    private final Scanner scanner = new Scanner(System.in);

    public ReportService(StudentRepo studentRepo, ResultRepo resultRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.resultRepo = resultRepo;
        this.courseRepo = courseRepo;
    }

    public void generateStudentReport() {
        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();

        Student student = studentRepo.getStudentById(studentId);
        
        // Error handling ekak damma student naththam crash wenna nathi wenna
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

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

        ArrayList<Results> resultList = resultRepo.searchResult(studentId);
       
        for (Results res : resultList) {
            if (res.getStudentID().equals(student.getStudentId())) {
                                
                Course course = courseRepo.findByCode(res.getCourseCode());
               
                if (course != null) {
                    System.out.printf("%-12s %-25s %-8d %-7.1f %-8s %-5.1f\n", 
                            res.getCourseCode(), 
                            course.getCourseName(), 
                            course.getCredits(), 
                            res.getMarks(), 
                            res.getGrade(),
                            res.getGradePoint());
    
                    totalCreditWeightedPoints += (res.getGradePoint() * course.getCredits());
                    totalCredits += course.getCredits();
                }
            }
        }

        System.out.println("-----------------------------------------");

        // --- WENAS KARAPU THANA --- 
        // Comment karala thibba ewa uncomment karala calculations gaththa
        double semesterGpa = GPACalculator.calculateSemesterGPA(studentId, student.getCurrentYear(), student.getCurrentSemester(), resultList, courseRepo);
        double overallGpa = GPACalculator.calculateOverallGPA(studentId, resultList, courseRepo);
        String academicStanding = GPACalculator.getAcademicStanding(overallGpa);

        System.out.printf("Semester GPA     : %.2f\n", semesterGpa);
        System.out.printf("Overall GPA      : %.2f\n", overallGpa);
        System.out.println("Total Credits    : " + totalCredits);
        System.out.println("Academic Standing: " + academicStanding);
        // --------------------------
        
        System.out.println("=========================================");
    }
}