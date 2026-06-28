package edu.ui;

import java.util.Scanner;

import edu.model.Results;
import edu.repository.ResultRepo;
import edu.service.ResultService;

public class MainMenu {

    private Scanner sc = new Scanner(System.in);

    // Repository & Service
    private final ResultRepo resultRepo = new ResultRepo();
    private final ResultService resultService = new ResultService(resultRepo);

    public void start() {

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println(" UNIVERSITY STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Add Course");
            System.out.println("5. View All Courses");
            System.out.println("6. Add Student Result");
            System.out.println("7. View All Results");
            System.out.println("8. Search Result");
            System.out.println("9. Exit");
            System.out.print("Enter Choice : ");

            try {

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.println("Add Student - TODO");
                        break;

                    case 2:
                        System.out.println("View Students - TODO");
                        break;

                    case 3:
                        System.out.println("Search Student - TODO");
                        break;

                    case 4:
                        System.out.println("Add Course - TODO");
                        break;

                    case 5:
                        System.out.println("View Courses - TODO");
                        break;

                    case 6:
                        addResult();
                        break;

                    case 7:
                        viewResults();
                        break;

                    case 8:
                        searchResult();
                        break;

                    case 9:
                        System.out.println("Thank You...");
                        break;

                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
                choice = 0;

            }

        } while (choice != 9);

    }

    // ==============================
    // Add Result
    // ==============================

    private void addResult() {

        try {

            System.out.print("Student ID : ");
            String studentID = sc.nextLine();

            System.out.print("Course Code : ");
            String courseCode = sc.nextLine();

            System.out.print("Academic Year : ");
            int year = Integer.parseInt(sc.nextLine());

            System.out.print("Semester : ");
            int semester = Integer.parseInt(sc.nextLine());

            System.out.print("Marks : ");
            double marks = Double.parseDouble(sc.nextLine());

            // Grade Calculation

            String grade;
            double gp;

            if (marks >= 85) {
                grade = "A";
                gp = 4.0;
            } else if (marks >= 75) {
                grade = "B+";
                gp = 3.7;
            } else if (marks >= 70) {
                grade = "B";
                gp = 3.3;
            } else if (marks >= 65) {
                grade = "C+";
                gp = 3.0;
            } else if (marks >= 60) {
                grade = "C";
                gp = 2.7;
            } else if (marks >= 55) {
                grade = "D+";
                gp = 2.3;
            } else if (marks >= 50) {
                grade = "D";
                gp = 2.0;
            } else {
                grade = "E";
                gp = 0.0;
            }

            Results result = new Results(
                    studentID,
                    courseCode,
                    year,
                    semester,
                    marks,
                    grade,
                    gp);

            resultService.addResult(result);

        } catch (Exception e) {

            System.out.println("Invalid Input.");

        }

    }

    // ==============================
    // View Results
    // ==============================

    private void viewResults() {

        if (resultService.getResults().isEmpty()) {

            System.out.println("No Results Found.");
            return;

        }

        for (Results r : resultService.getResults()) {

            r.displayResultsDetails();
            System.out.println("--------------------------------");

        }

    }

    // ==============================
    // Search Result
    // ==============================

    private void searchResult() {

        try {

            System.out.print("Student ID : ");
            String studentID = sc.nextLine();

            System.out.print("Course Code : ");
            String courseCode = sc.nextLine();

            System.out.print("Academic Year : ");
            int year = Integer.parseInt(sc.nextLine());

            System.out.print("Semester : ");
            int semester = Integer.parseInt(sc.nextLine());

            Results result = resultService.findResultByStudentID(
                    studentID,
                    courseCode,
                    year,
                    semester);

            if (result == null) {

                System.out.println("Result Not Found.");

            } else {

                result.displayResultsDetails();

            }

        } catch (Exception e) {

            System.out.println("Invalid Input.");

        }

    }

}

