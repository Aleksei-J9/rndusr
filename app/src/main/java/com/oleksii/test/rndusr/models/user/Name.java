package com.oleksii.test.rndusr.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("title")
    
    private String title;
    @SerializedName("first")
    
    private String first;
    @SerializedName("last")
    
    private String last;

    /**
     * No args constructor for use in serialization
     *
     */
    public Name() {
    }

    /**
     *
     * @param last
     * @param title
     * @param first
     */
    public Name(String title, String first, String last) {
        super();
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
