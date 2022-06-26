package com.oleksii.test.rndusr.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.oleksii.test.rndusr.models.user.User;

import java.util.List;

public class UserResult {

    @SerializedName("results")
    
    private List<User> users = null;
    @SerializedName("info")
    
    private Info info;

    public UserResult() {
    }

    /**
     *
     * @param results
     * @param info
     */
    public UserResult(List<User> results, Info info) {
        super();
        this.users = results;
        this.info = info;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
