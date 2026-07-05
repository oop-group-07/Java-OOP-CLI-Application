package edu.repository;

import java.util.ArrayList;

import edu.model.Results;

public class ResultRepo {

    private ArrayList<Results> resultList = new ArrayList<>();

    public void addResult(Results result) {
        resultList.add(result);
    }

    public ArrayList<Results> getAllResults() {
        return resultList;
    }

    public Results searchResult(String studentID,
                                         String courseCode,
                                         int academicYear,
                                         int semester) {

        for (Results result : resultList) {
            if (result.getStudentID().equals(studentID)
                    && result.getCourseCode().equals(courseCode)
                    && result.getAcademicYear() == academicYear
                    && result.getSemester() == semester) {

                return result;
            }
        }

        return null;
    }
            //check duplicate result
            public boolean isDuplicate(String studentID, String courseCode, int academicYear, int semester) {
                
               return searchResult(studentID, courseCode, academicYear, semester) != null;
            }
        }

       