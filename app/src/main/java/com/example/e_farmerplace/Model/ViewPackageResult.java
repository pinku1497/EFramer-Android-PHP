package com.example.e_farmerplace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewPackageResult
{
   @SerializedName("packagename")
   @Expose
   private String ppackage;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("rate")
    @Expose
    private String rate;

    @SerializedName("description")
    @Expose
    private String description;

    public String getPpackage() {
        return ppackage;
    }

    public void setPpackage(String ppackage) {
        this.ppackage = ppackage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
