package com.oleksii.test.rndusr.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob {

    @SerializedName("date")
    
    private String date;
    @SerializedName("age")
    
    private int age;

    /**
     * No args constructor for use in serialization
     *
     */
    public Dob() {
    }

    /**
     *
     * @param date
     * @param age
     */
    public Dob(String date, int age) {
        super();
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
