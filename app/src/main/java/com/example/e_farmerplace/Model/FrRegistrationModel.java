package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FrRegistrationModel
{
    @SerializedName("result")
    @Expose

    private List<FrRegistrationResult> results=null;

    public List<FrRegistrationResult> getResults() {
        return results;
    }

    public void setResults(List<FrRegistrationResult> results) {
        this.results = results;
    }
}
