package edu.service;

import edu.model.*;
import java.util.ArrayList;

public class GPACalculator 

{

    private ArrayList<Results> results;
    private ArrayList<Course> courses;

    public GPACalculator(ArrayList<Results> results, ArrayList<Course> courses) 
    {
        this.results = results;
        this.courses = courses;
    }

    private int getCredits(String courseCode) 
    
    {
        for (Course c : courses) 
        {
            if (c.getCourseCode().equals(courseCode)) 
                
            {
                return c.getCredits();
            }
        }
        return 0;
    }

    public double calculateGPA(String studentID, int year, int semester) 
    {

        double totalPoints = 0;
        int totalCredits = 0;

        for (Results r : results) 
        {

            if (r.getStudentID().equals(studentID)
                    && r.getAcademicYear() == year
                    && r.getSemester() == semester) 
            {

                int credits = getCredits(r.getCourseCode());

                totalPoints += r.getGradePoint() * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits == 0) return 0;

        return totalPoints / totalCredits;
    }

    public String getStanding(double gpa) 
    {

        if (gpa >= 3.70) return "First Class";
        else if (gpa >= 3.30) return "Second Upper";
        else if (gpa >= 3.00) return "Second Lower";
        else if (gpa >= 2.00) return "General Pass";
        else return "Academic Warning";
    }
}
