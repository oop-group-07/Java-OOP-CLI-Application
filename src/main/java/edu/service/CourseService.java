package edu.service;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.file.fileManager;
import edu.model.Course;
import edu.repository.CourseRepository;

public class CourseService {
    private CourseRepository repository; 
    Scanner scanner = new Scanner(System.in);

    //Connect repository using constructor injection
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public void addCourse() {

        try {

            // Get course information from user
            System.out.println("\n===== ADD COURSE =====");

            System.out.print("Course Code: ");
            String courseCode = scanner.nextLine();

            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();

            System.out.print("Credits: ");
            int credits = scanner.nextInt();

            System.out.print("Academic Year: ");
            int academicYear = scanner.nextInt();

            System.out.print("Semester: ");
            int semester = scanner.nextInt();

            scanner.nextLine();

            // Duplicate course code validation
            if (repository.findByCode(courseCode) != null) {
                System.out.println(
                        "Error: Course Code '" + courseCode + "' already exists!"
                );
                return;
            }

            // Course code validation
            if (!courseCode.matches("^(?=.*[a-zA-Z])(?=.*\\d).+$")) {
                System.out.println(
                        "Error: Course code must contain both letters and numbers!"
                );
                return;
            }

            // Course name validation
            if (courseName.matches(".*\\d.*")) {
                System.out.println(
                        "Error: Course name cannot contain numbers!"
                );
                return;
            }

            // Credit validation
            if (credits <= 0) {
                System.out.println(
                        "Error: Credit must be greater than 0!"
                );
                return;
            }

            // Academic year validation
            if (academicYear < 1 || academicYear > 4) {
                System.out.println(
                        "Error: Academic year must be between 1 and 4!"
                );
                return;
            }

            // Semester validation
            if (semester != 1 && semester != 2) {
                System.out.println(
                        "Error: Semester must be 1 or 2!"
                );
                return;
            }

            // Create Course object
            Course course = new Course(
                    courseCode,
                    courseName,
                    credits,
                    academicYear,
                    semester
            );

            // Add course to repository
            repository.addCourse(course);

            System.out.println("\nCourse added successfully!");

        } catch (InputMismatchException e) {

            System.out.println("\nError: Please enter valid input.");

            // Clear invalid input
            scanner.nextLine();

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
        }
    }

    //view all courses
    public void viewAllCourses(){
        try{
        ArrayList<Course> List = repository.getAllCourses();
        if(List.isEmpty()){
            System.out.println("No courses available.");
            return;
        }
        System.out.println("\n--- COURSE LIST ---");
        for(Course c : List){
            System.out.println(c);
        }
    }catch (Exception e){
        System.out.println("\nError while retrieving courses: "+ e.getMessage());
    }
    }

    //search course by course code
    public void searchCourse(){

        System.out.print("Course Code: ");
        String courseCode = scanner.nextLine();

        // Duplicate course code validation
            if (repository.findByCode(courseCode) != null) {
                System.out.println(
                        "Error: Course Code '" + courseCode + "' already exists!"
                );
                return;
            }

            // Course code validation
            if (!courseCode.matches("^(?=.*[a-zA-Z])(?=.*\\d).+$")) {
                System.out.println(
                        "Error: Course code must contain both letters and numbers!"
                );
                return;
            }

        try{
        Course course = repository.findByCode(courseCode);
        if (course != null) {
            System.out.println("\n--- Course Found ---");
            System.out.println(course);
        }else{
            System.out.println("\nCourse not found with Code: " + courseCode);
        }
    }catch (Exception e){
        System.out.println("\nError while searching for the course:"+ e.getMessage());
    }
    }

    //update courses
    public boolean updateCourse() {
        System.out.print("Course Code: ");
        String courseCode = scanner.nextLine();
        
        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Credits: ");
        int credits = scanner.nextInt();

        System.out.print("Academic Year: ");
        int academicYear = scanner.nextInt();

        System.out.print("Semester: ");
        int semester = scanner.nextInt();

        scanner.nextLine();

        // Duplicate course code validation
        if (repository.findByCode(courseCode) != null) {
            System.out.println(
                    "Error: Course Code '" + courseCode + "' already exists!"
            );
        }

        // Course code validation
        if (!courseCode.matches("^(?=.*[a-zA-Z])(?=.*\\d).+$")) {
            System.out.println(
                    "Error: Course code must contain both letters and numbers!"
            );
        }

        // Course name validation
        if (courseName.matches(".*\\d.*")) {
            System.out.println(
                    "Error: Course name cannot contain numbers!"
            );
        }

        // Credit validation
            if (credits <= 0) {
            System.out.println(
                     "Error: Credit must be greater than 0!"
            );
        }

        // Academic year validation
        if (academicYear < 1 || academicYear > 4) {
            System.out.println(
                     "Error: Academic year must be between 1 and 4!"
            );
        }

        // Semester validation
        if (semester != 1 && semester != 2) {
            System.out.println(
                "Error: Semester must be 1 or 2!"
            );
        }

        // Create Course object
        Course updatedCourse = new Course(
                courseCode,
                courseName,
                credits,
                academicYear,
                semester
        );

        try {
            Course existing = repository.findByCode(courseCode);
            if (existing == null) {
                System.out.println("Course not found!");
                return false;
            }

            //validations
            //course name must not contain numeric characters
            if (updatedCourse.getCourseName().matches(".*\\d.*")) {
                System.out.println("Invalid course name!");
                return false;
            }

            //credits must be a positive value
            if (updatedCourse.getCredits() <= 0) {
                System.out.println("Invalid credits!");
                return false;
            }

            //acedemic year must be between 1 and 4
            if (updatedCourse.getAcademicYear() < 1 || updatedCourse.getAcademicYear() > 4) {
                System.out.println("Invalid academic year!");
                return false;
            }

            //semester must be either 1 or 2
            if (updatedCourse.getSemester() != 1 && updatedCourse.getSemester() != 2) {
                System.out.println("Invalid semester!");
                return false;
            }

            //update logic
            existing.setCourseName(updatedCourse.getCourseName());
            existing.setCredits(updatedCourse.getCredits());
            existing.setAcademicYear(updatedCourse.getAcademicYear());
            existing.setSemester(updatedCourse.getSemester());

            System.out.println("\nCourse updated successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
            return false;
        }
    }

    //delete course by course code
    public boolean deleteCourse() {
        try {
            System.out.print("Enter Course ID to delete: ");
            String courseCode = scanner.nextLine();
            //search for the course using the course code 
            Course existing = repository.findByCode(courseCode);
            if (existing == null) {
                System.out.println("\nCourse not found!");
                return false;
            }

            //delete course from repository
            boolean result = repository.deleteCourse(existing);

            if (result) {
                System.out.println("\nCourse deleted successfully!");
            }
            return result;

        } catch (Exception e) {
            System.out.println("\nError while deleting the course: " + e.getMessage());
            return false;
        }
    }

    // Load courses from file to ArrayList
    public void loadCourses() {
        ArrayList<Course> loadedCourses = fileManager.retrieveCourseData();
        repository.loadCourse(loadedCourses);
    }
}