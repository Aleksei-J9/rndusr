package com.oleksii.test.rndusr.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("latitude")
    
    private String latitude;
    @SerializedName("longitude")
    
    private String longitude;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coordinates() {
    }

    /**
     *
     * @param latitude
     * @param longitude
     */
    public Coordinates(String latitude, String longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
