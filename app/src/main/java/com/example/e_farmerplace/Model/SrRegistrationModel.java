package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SrRegistrationModel
{
    @SerializedName("result")
    @Expose

    private List<SrRegistrationResult> results=null;

    public List<SrRegistrationResult> getResults() {
        return results;
    }

    public void setResults(List<SrRegistrationResult> results) {
        this.results = results;
    }
}
