package edu.ui;

import java.util.Scanner;

import edu.service.CourseService;
import edu.service.ReportService;
import edu.service.ResultService;
import edu.service.StudentService;

public class MainMenu {

    private final Scanner scanner;
    private final CourseService courseService;
    private final ResultService resultService;
    private final StudentService studentService;
    private final ReportService reportService;

    public MainMenu(
            StudentService studentService,
            CourseService courseService,
            ResultService resultService,
            ReportService reportService
            ){

        this.scanner = new Scanner(System.in);

         this.studentService = studentService;
         this.courseService = courseService;
         this.resultService = resultService;
         this.reportService = reportService;
    }

    public void start() {
        int choice = 0;

        do {

            System.out.println("\n==============================================");
            System.out.println("       UNIVERSITY STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================================");

            System.out.println("1.  Add New Student");
            System.out.println("2.  View All Students");
            System.out.println("3.  Search Student by ID");
            System.out.println("4.  Update Student");
            System.out.println("5.  Delete Student");
            System.out.println("6.  Add Course");
            System.out.println("7.  View All Courses");
            System.out.println("8.  Update Course");
            System.out.println("9.  Delete Course");
            System.out.println("10. Add Marks for a Student");
            System.out.println("11. Calculate GPA");
            System.out.println("12. Generate Student Report");
            System.out.println("13. Exit");

            System.out.println("----------------------------------------------");

            try {

                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        studentService.AddStudent();
                        break;

                    case 2:
                        studentService.viewAllStudents();
                        break;

                    case 3:
                        studentService.getStudentById();
                        break;

                    case 4:
                        studentService.updateStudent();
                        break;

                    case 5:
                        studentService.deleteStudent();
                        break;

                    case 6:
                        courseService.addCourse();
                        break;

                    case 7:
                        courseService.viewAllCourses();
                        break;

                    case 8:
                        //courseService.updateCourse();
                        break;

                    case 9:
                        //courseService.deleteCourse();
                        break;

                    case 10: 
                        //resultService.addMarks();
                        break;

                    case 11:
                        //gpaCalculation.calculateGPA();
                        break;

                    case 12:
                        //reportService.genarateReport();
                        break;

                    case 13:
                        System.out.println("Exiting the system...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select 1 - 13.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please enter a number.");

            }

        } while (choice != 13);
    }
}
