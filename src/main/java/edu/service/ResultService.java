package edu.service;

import edu.model.Results;
import edu.repository.ResultRepo;
import java.util.ArrayList;

public class ResultService {

    private ResultRepo resultRepo;

    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public void addResult(Results result) {

        try {

            if (result.getAcademicYear() < 1 || result.getAcademicYear() > 4) {
                throw new IllegalArgumentException("Academic year must be between 1 and 4.");
            }

            if (result.getSemester() != 1 && result.getSemester() != 2) {
                throw new IllegalArgumentException("Semester must be 1 or 2.");
            }

            if (result.getMarks() < 0 || result.getMarks() > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            if (result.getGradePoint() < 0.0 || result.getGradePoint() > 4.0) {
                throw new IllegalArgumentException("Grade point must be between 0.0 and 4.0.");
            }

            if (resultRepo.findResultByStudentID(
                    result.getStudentID(),
                    result.getCourseCode(),
                    result.getAcademicYear(),
                    result.getSemester()) != null) {

                throw new IllegalArgumentException("Result already exists.");
            }

            resultRepo.addResult(result);

            System.out.println("Result added successfully.");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

    public ArrayList<Results> getResults() {
        return resultRepo.getResults();
    }

    public Results findResultByStudentID(String studentID,
                                         String courseCode,
                                         int academicYear,
                                         int semester) {

        return resultRepo.findResultByStudentID(studentID,
                                                courseCode,
                                                academicYear,
                                                semester);
    }

}