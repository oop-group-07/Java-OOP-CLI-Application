package edu.service;

import java.util.ArrayList;
import java.util.Scanner;

import edu.file.fileManager;
import edu.model.Course;
import edu.model.Results;
import edu.model.Student;
import edu.repository.CourseRepository;
import edu.repository.ResultRepo;
import edu.repository.StudentRepo;
import edu.model.GPACalculator; // GPACalculator

public class ResultService {

    private final Scanner scanner = new Scanner(System.in);
    private final ResultRepo resultRepo;
    private final StudentRepo studentRepo;
    private final CourseRepository courseRepo;

    public ResultService(ResultRepo resultRepo, StudentRepo studentRepo, CourseRepository courseRepo) {
        this.resultRepo = resultRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public void addResult() {

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter Course ID: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
       
        try {

            //student validation
            if (studentRepo.getStudentById(studentID) == null) {
                throw new IllegalArgumentException("Student with ID " + studentID + " does not exist.");
            }

            //course validation
            Course course = courseRepo.findByCode(courseCode);
            if (course == null) {
                throw new IllegalArgumentException("Course with code " + courseCode + " does not exist.");
            }

            //marks validation
            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            
            // grade calculation (GPACalculator class used)
            String grade = GPACalculator.calculateGrade(marks);
            double gradePoint = GPACalculator.calculateGradePoint(marks);
            // --------------------------

            //automatically copy the academic year and semester from the course details
            Results result = new Results(studentID, courseCode, course.getAcademicYear(), course.getSemester(), marks, grade, gradePoint);
            resultRepo.addResult(result);

            System.out.println("\n Marks added successfully.");

            System.out.println("Grade: " + grade);
            System.out.println("Grade Point: " + gradePoint);
            System.out.println("Academic Year: " + course.getAcademicYear());
            System.out.println("Semester: " + course.getSemester());

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    // Load results from file to ArrayList
    public void loadResults() {
        ArrayList<Results> loadedResults = fileManager.retrieveResults();
        resultRepo.loadResults(loadedResults);
    }
}