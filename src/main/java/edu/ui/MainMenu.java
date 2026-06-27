package edu.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.service.StudentService;

public class MainMenu {

    StudentService studentService = new StudentService();

    public void start() {

    Scanner scanner = new Scanner(System.in); 

    for (int i = 0; i < 5; i++) {

        System.out.println("Welcome to the Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Exit");

        System.out.print("Please select an option: ");

        try {
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    studentService.checkAddStudent();
                    break;
                case 2:
                    studentService.viewAllStudents();
                    break;
                case 3:
                    studentService.getStudentById();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); 
        }
    }

    scanner.close(); 
}
}
