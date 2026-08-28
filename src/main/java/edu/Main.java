package edu;

import edu.repository.CourseRepository;
import edu.repository.ResultRepo;
import edu.repository.StudentRepo;
import edu.service.CourseService;
import edu.service.ReportService;
import edu.service.ResultService;
import edu.service.StudentService;
import edu.ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        //Create repository objects to manage application data
        StudentRepo studentRepo = new StudentRepo();
        CourseRepository courseRepo = new CourseRepository();
        ResultRepo resultRepo = new ResultRepo();
        
        //Create service objects and inject the required repositories
        //Constructor-based Dependency Injection
        StudentService studentService = new StudentService(studentRepo);
        CourseService courseService = new CourseService(courseRepo);
        ResultService resultService = new ResultService(resultRepo, studentRepo, courseRepo);
        ReportService reportService = new ReportService(studentRepo,resultRepo,courseRepo);

        // Load data from file when application starts
        studentService.loadStudents();
        courseService.loadCourses();
        resultService.loadResults();
        
        //Program Starting Entry Point
        MainMenu menu = new MainMenu(studentService,courseService,resultService,reportService);
        menu.start();
    }
}
