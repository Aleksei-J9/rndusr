package com.oleksii.test.rndusr.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone {
    @SerializedName("offset")
    
    private String offset;
    @SerializedName("description")
    
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public Timezone() {
    }

    /**
     *
     * @param offset
     * @param description
     */
    public Timezone(String offset, String description) {
        super();
        this.offset = offset;
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
