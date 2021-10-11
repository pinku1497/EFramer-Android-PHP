package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentModel
{
    @SerializedName("result")
    @Expose

    private List<PaymentResult> results=null;

    public List<PaymentResult> getResults() {
        return results;
    }

    public void setResults(List<PaymentResult> results) {
        this.results = results;
    }
}
