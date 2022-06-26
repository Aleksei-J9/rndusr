package com.oleksii.test.rndusr.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Street {
    @SerializedName("number")
    
    private int number;
    @SerializedName("name")
    
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Street() {
    }

    /**
     * @param number
     * @param name
     */
    public Street(int number, String name) {
        super();
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
