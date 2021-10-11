package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SrProductModel
{
    @SerializedName("result")
    @Expose

    private List<SrProductResult> results=null;

    public List<SrProductResult> getResults() {
        return results;
    }

    public void setResults(List<SrProductResult> results) {
        this.results = results;
    }
}
