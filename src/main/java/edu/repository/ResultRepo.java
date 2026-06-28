package edu.repository;

import edu.model.Results;
import java.util.ArrayList;

public class ResultRepo {

    private ArrayList<Results> results = new ArrayList<>();

    public void addResult(Results result) {
        results.add(result);
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public Results findResultByStudentID(String studentID,
                                         String courseCode,
                                         int academicYear,
                                         int semester) {

        for (Results result : results) {

            if (result.getStudentID().equals(studentID)
                    && result.getCourseCode().equals(courseCode)
                    && result.getAcademicYear() == academicYear
                    && result.getSemester() == semester) {

                return result;
            }
        }

        return null;
    }
}