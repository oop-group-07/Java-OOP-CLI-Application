package edu.repository;

import java.util.ArrayList;

import edu.model.Results;

public class ResultRepo {

    private ArrayList<Results> resultList = new ArrayList<>();

    public void addResult(Results result) {
        resultList.add(result);
    }

    public ArrayList<Results> searchResult(String studentID) {
        ArrayList<Results> resultListByStdID = new ArrayList<>();

        for (Results result : resultList) {
            if (result.getStudentID().equals(studentID)) {
                resultListByStdID.add(result);
            }
        }

        return resultListByStdID;
    }

    // Load Results Details form the file to arraylist
    public void loadResults(ArrayList<Results> results) {
        this.resultList.clear();
        this.resultList.addAll(results);
    }
}

       