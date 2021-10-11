package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageModel
{
    @SerializedName("result")
    @Expose

    private List<ImageResult> results=null;

    public List<ImageResult> getResults() {
        return results;
    }

    public void setResults(List<ImageResult> results) {
        this.results = results;
    }
}
