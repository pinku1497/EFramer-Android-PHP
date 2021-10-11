package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewProductModel
{
    @SerializedName("result")
    @Expose

    private List<VieewProductResult> results=null;

    public List<VieewProductResult> getResults()
    {
        return results;
    }
    public void setResults(List<VieewProductResult> results)
    {
        this.results = results;
    }
}

