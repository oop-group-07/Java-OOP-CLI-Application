package edu.repository;
import edu.model.Course;
import java.util.ArrayList;

public class CourseRepository {
    private ArrayList<Course> courses = new ArrayList<>();

    //add course
    public void addCourse(Course course) {
        courses.add(course);
    }

    //get all courses
    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    //search course by course code
    public Course findByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)){
                return course;
            }
        }
        return null;
    }
    //update course details
    public boolean updateCourse(Course existing, Course updatedCourse){

    existing.setCourseName(updatedCourse.getCourseName());
    existing.setCredits(updatedCourse.getCredits());
    existing.setAcademicYear(updatedCourse.getAcademicYear());
    existing.setSemester(updatedCourse.getSemester());

    return true;
}

    //delete course
    public boolean deleteCourse(Course course){
        return courses.remove(course);
    }    
        
}

