package edu.repository;

import java.util.ArrayList;

import edu.model.Student;

public class StudentRepo {

    private final ArrayList<Student> students = new ArrayList<>();

    // Method to get all students
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Method to get a student by ID
    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // update student
    public boolean updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentId()
                    .equals(updatedStudent.getStudentId())) {

                students.set(i, updatedStudent);
                return true;
            }
        }

        return false;
    }

    // Method to delete student
    public boolean deleteStudent(String studentId) {

        Student student = getStudentById(studentId);

        if (student != null) {

            students.remove(student);
            return true;
        }

        return false;
    }

    // Load Student Details form the file to arraylist
    public void loadStudents(ArrayList<Student> students) {
        this.students.clear();
        this.students.addAll(students);
    }
}
