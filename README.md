# 🎓 University Student Management System

A Java Object-Oriented Programming (OOP) based Command Line Interface (CLI) application designed to manage university student records, courses, academic results, GPA calculations, and file-based data storage.

## 📌 Project Overview

This project was developed as part of a Java OOP coursework assignment to demonstrate the practical implementation of Object-Oriented Programming concepts including:

- Classes and Objects
- Encapsulation
- Inheritance
- Abstraction
- Interfaces
- Polymorphism
- Exception Handling
- ArrayList Collections
- File Handling

The system allows university departments to manage students, courses, marks, grades, GPA calculations, academic reports, and persistent data storage.

---

## ✨ Features

### Student Management
- Add New Student
- View All Students
- Search Student by ID

### Course Management
- Add New Course
- View All Courses

### Academic Records
- Add Marks for Students
- Automatic Grade Calculation
- Grade Point Calculation
- Semester GPA Calculation
- Overall GPA Calculation
- Academic Standing Evaluation

### Reports
- Generate Student Academic Report
- Display Course Results
- Display GPA and Academic Standing

### Data Persistence
- Save Data to Files
- Load Data from Files

### Validation & Error Handling
- Duplicate Student Prevention
- Duplicate Course Prevention
- Marks Validation (0–100)
- Academic Year Validation
- Semester Validation
- Exception Handling using Try-Catch

---

## 🏗️ Project Structure

```
src/
│
├── model/
│   ├── Person.java
│   ├── Student.java
│   ├── Course.java
│   └── Result.java
│
├── service/
│   ├── StudentService.java
│   ├── CourseService.java
│   ├── ResultService.java
│   ├── GPACalculator.java
│   └── ReportService.java
│
├── repository/
│   ├── StudentRepository.java
│   ├── CourseRepository.java
│   └── ResultRepository.java
│
├── file/
│   └── FileManager.java
|___ ui/
│    └── MainMenu.java
|
└── Main.java
```

---

## 📊 GPA Calculation

### Grade Scale

| Marks | Grade | Grade Point |
|---------|---------|---------|
| 85 - 100 | A | 4.0 |
| 75 - 84 | B+ | 3.7 |
| 70 - 74 | B | 3.3 |
| 65 - 69 | C+ | 3.0 |
| 60 - 64 | C | 2.7 |
| 55 - 59 | D+ | 2.3 |
| 50 - 54 | D | 2.0 |
| Below 50 | E | 0.0 |

### Academic Standing

| GPA Range | Standing |
|------------|-----------|
| 3.70 - 4.00 | First Class |
| 3.30 - 3.69 | Second Upper |
| 3.00 - 3.29 | Second Lower |
| 2.00 - 2.99 | General Pass |
| Below 2.00 | Academic Warning |

---

## 💾 File Storage

The system stores data using text files:

| File Name | Description |
|------------|-------------|
| students.txt | Student Records |
| courses.txt | Course Details |
| results.txt | Student Results |

---

## 🚀 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (ArrayList)
- File Handling
- Exception Handling
- Command Line Interface (CLI)
- Layered Architecture

---

## 🎯 Learning Outcomes

This project demonstrates:

- Real-world OOP Design
- Data Management using Collections
- Academic GPA Calculation Logic
- Software Validation Techniques
- Exception Handling Best Practices

---

## 📜 License

This project was developed for educational purposes as part of a Java OOP coursework assignment project.

---

⭐ If you found this project useful, consider giving it a star on GitHub.
