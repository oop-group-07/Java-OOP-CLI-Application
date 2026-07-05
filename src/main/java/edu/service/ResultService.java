package edu.service;

import edu.model.Course;
import edu.model.Results;
import edu.repository.CourseRepository;
import edu.repository.ResultRepo;
import edu.repository.StudentRepo;

public class ResultService {

    private final ResultRepo resultRepo;
    private final StudentRepo studentRepo;
    private final CourseRepository courseRepo;

    public ResultService(ResultRepo resultRepo, StudentRepo studentRepo, CourseRepository courseRepo) {
        this.resultRepo = resultRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public  void addResult(String studentID, String courseCode, double marks) {
       
            try{

                //student validation
                if(studentRepo.getStudentById(studentID) == null){
                    throw new IllegalArgumentException("Student with ID " + studentID + " does not exist.");
                }

                //course validation
                Course course = courseRepo.findByCode(courseCode);
                if(course == null){
                    throw new IllegalArgumentException("Course with code " + courseCode + " does not exist.");
                }

                //duplicate result validation
                if(resultRepo.isDuplicate(studentID, courseCode, course.getAcademicYear(), course.getSemester())){
                    throw new IllegalArgumentException("Result for student " + studentID + " and course " + courseCode + " already exists.");
                }

                //marks validation
                if(marks < 0 || marks > 100){
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }

                //grade calculation
                String grade;
                double gradePoint;

                if (marks >= 85) {
                    grade = "A";
                    gradePoint = 4.0;
                } else if (marks >= 75) {
                    grade = "B+";
                    gradePoint = 3.7;
                } else if (marks >= 70) {
                    grade = "B";
                    gradePoint = 3.3;
                } else if (marks >= 65) {
                    grade = "C+";
                    gradePoint = 3.0;
                } else if (marks >= 60) {
                    grade = "C";
                    gradePoint = 2.7;
                } else if (marks >= 55) {
                    grade = "D+";
                    gradePoint = 2.3;
                } else if (marks >= 50) {
                    grade = "D";
                    gradePoint = 2.0;
                } else {
                    grade = "E";
                    gradePoint = 0.0;
                }

                //automatically copy the academic year and semester from the course details
                Results result = new Results(studentID, courseCode, course.getAcademicYear(), course.getSemester(), marks, grade, gradePoint);
                resultRepo.addResult(result);

                System.out.println("\n Marks added successfully.");

                System.out.println("Grade: " + grade);
                System.out.println("Grade Point: " + gradePoint);
                System.out.println("Academic Year: " + course.getAcademicYear());
                System.out.println("Semester: " + course.getSemester());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    //view results

    public void viewAllResults(){
        if(resultRepo.getAllResults().isEmpty()){
            System.out.println("No results available.");
            return;
        }
        System.out.println("\n ===============RESULT LIST===============");
        System.out.println("Student ID\tCourse Code\tAcademic Year\tSemester\tMarks\tGrade\tGrade Point");
        
        for(Results result : resultRepo.getAllResults()){
            System.out.println(result.getStudentID() + "\t" + result.getCourseCode() + "\t" + result.getAcademicYear() + "\t" + result.getSemester() + "\t" + result.getMarks() + "\t" + result.getGrade() + "\t" + result.getGradePoint());
        }
    }

    //Search result

    public void searchResult(String studentId, String courseCode){
        Results result = resultRepo.searchResult(studentId, courseCode, 0, 0);
        if(result == null){
            System.out.println("No result found for student ID " + studentId + " and course code " + courseCode);
            return;
        }
        System.out.println("\n ===============RESULT DETAILS===============");
        System.out.println("Student ID: " + result.getStudentID());
        System.out.println("Course Code: " + result.getCourseCode());
        System.out.println("Academic Year: " + result.getAcademicYear());
        System.out.println("Semester: " + result.getSemester());
        System.out.println("Marks: " + result.getMarks());
        System.out.println("Grade: " + result.getGrade());
        System.out.println("Grade Point: " + result.getGradePoint());
    }
    }