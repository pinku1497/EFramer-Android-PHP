package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewPackageModel
{
    @SerializedName("result")
    @Expose

    private List<ViewPackageResult> results=null;

    public List<ViewPackageResult> getResults() {
        return results;
    }

    public void setResults(List<ViewPackageResult> results) {
        this.results = results;
    }
}

