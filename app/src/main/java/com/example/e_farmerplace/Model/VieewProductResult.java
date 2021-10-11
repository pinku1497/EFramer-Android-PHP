package com.example.e_farmerplace.Model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VieewProductResult
{

    @SerializedName("fertname")
    @Expose
    private String fertilizer;

    @SerializedName("image")
    @Expose
    private Bitmap image;

    @SerializedName("rate")
    @Expose
    private String rate;

    @SerializedName("description")
    @Expose
    private String description;

    public String getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
