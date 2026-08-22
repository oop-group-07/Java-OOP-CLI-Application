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
        //program starting entry point
        StudentRepo studentRepo = new StudentRepo();
        CourseRepository courseRepo = new CourseRepository();
        ResultRepo resultRepo = new ResultRepo();
        
        StudentService studentService = new StudentService(studentRepo);
        CourseService courseService = new CourseService(courseRepo);
        ResultService resultService = new ResultService(resultRepo, studentRepo, courseRepo);
        ReportService reportService = new ReportService();
        
        MainMenu menu = new MainMenu(studentService,courseService,resultService,reportService);
        menu.start();
    }
}