package edu.service;
import edu.model.Course;
import edu.repository.CourseRepository;
import java.util.ArrayList;

public class CourseService {
    private CourseRepository repository; 

    //Connect repository using constructor injection
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    //add course with validation
    public boolean addCourse(Course course) {
        try{
        //Check if Course Code already exists (Duplicate Check)
        if(repository.findByCode(course.getCourseCode()) !=null){
            System.out.println("Error : Course Code'"+ course.getCourseCode() +"'already exists!");
            return false;
        }
        //
        if(!course.getCourseCode().matches("^(?=.*[a-zA-Z])(?=.*\\d).+$")) {
            System.out.println("Error : Course code must contain both Letters ans Numbers!");
            return false;
        }

        //Check if Course Name contains numbers
        if (course.getCourseName().matches(".*\\d.*")) {
            System.out.println("Error :Course name cannot contain numbers!");
            return false;
        }

        //Check if credit value is greater than 0
        if(course.getCredits() <= 0){
            System.out.println("Error : Credit must be greater than 0!");
            return false;
        }
        //Check if academic year is between 1 and 4
        if(course.getAcademicYear() < 1 || course.getAcademicYear() > 4){
            System.out.println("Error : Academic year must between 1 and 4!");
            return false;
        }
        //Check if Semester is 1 or 2
        if(course.getSemester() !=1 && course.getSemester() !=2){
            System.out.println("Error : Semester must be 1 or 2!");
            return false;
        }
        // If all validations pass, save course to repository and return true
        repository.addCourse(course);
        System.out.println("Course added successfully!");
        return true;

        }catch (NullPointerException e){
            System.out.println("Error: A null pointer exception occurred while adding the course. Check if data is missing.");
            return false;

        }catch (Exception e){
            System.out.println("An unexpected error occurred:"+ e.getMessage());
            return false;
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
        System.out.println("Error while retrieving courses: "+ e.getMessage());
    }
    }

    //search course by course code
    public void searchCourse(String courseCode){
        try{
        Course course = repository.findByCode(courseCode);
        if (course != null) {
            System.out.println("\n--- Course Found ---");
            System.out.println(course);
        }else{
            System.out.println("Course not found with Code: " + courseCode);
        }
    }catch (Exception e){
        System.out.println("Error while searching for the course:"+ e.getMessage());
    }
    }
}
