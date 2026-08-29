package edu.model;

import java.util.ArrayList;
import edu.model.Results;
import edu.model.Course;
import edu.repository.CourseRepository;

public class GPACalculator {

    public static String calculateGrade(double marks) {
        if (marks >= 85 && marks <= 100) return "A";
        else if (marks >= 75) return "B+";
        else if (marks >= 70) return "B";
        else if (marks >= 65) return "C+";
        else if (marks >= 60) return "C";
        else if (marks >= 55) return "D+";
        else if (marks >= 50) return "D";
        else return "E";
    }

    public static double calculateGradePoint(double marks) {
        if (marks >= 85 && marks <= 100) return 4.0;
        else if (marks >= 75) return 3.7;
        else if (marks >= 70) return 3.3;
        else if (marks >= 65) return 3.0;
        else if (marks >= 60) return 2.7;
        else if (marks >= 55) return 2.3;
        else if (marks >= 50) return 2.0;
        else return 0.0;
    }

    public static String getAcademicStanding(double overallGPA) {
        if (overallGPA >= 3.70) return "First Class";
        else if (overallGPA >= 3.30) return "Second Upper";
        else if (overallGPA >= 3.00) return "Second Lower";
        else if (overallGPA >= 2.00) return "General Pass";
        else return "Academic Warning";
    }

    // Semester GPA calculation eka oyage CourseRepository eka use wena widiyata hadala thiyenne
    public static double calculateSemesterGPA(String studentID, int academicYear, int semester, ArrayList<Results> results, CourseRepository courseRepo) {
        double totalWeightedPoints = 0.0;
        int totalCredits = 0;

        for (Results res : results) {
            if (res.getStudentID().equals(studentID) && res.getAcademicYear() == academicYear && res.getSemester() == semester) {
                Course course = courseRepo.findByCode(res.getCourseCode());
                if (course != null) {
                    totalWeightedPoints += (res.getGradePoint() * course.getCredits());
                    totalCredits += course.getCredits();
                }
            }
        }
        return totalCredits == 0 ? 0.0 : (totalWeightedPoints / totalCredits);
    }

    // Overall GPA calculation eka oyage CourseRepository eka use wena widiyata hadala thiyenne
    public static double calculateOverallGPA(String studentID, ArrayList<Results> results, CourseRepository courseRepo) {
        double totalWeightedPoints = 0.0;
        int totalCredits = 0;

        for (Results res : results) {
            if (res.getStudentID().equals(studentID)) {
                Course course = courseRepo.findByCode(res.getCourseCode());
                if (course != null) {
                    totalWeightedPoints += (res.getGradePoint() * course.getCredits());
                    totalCredits += course.getCredits();
                }
            }
        }
        return totalCredits == 0 ? 0.0 : (totalWeightedPoints / totalCredits);
    }
}