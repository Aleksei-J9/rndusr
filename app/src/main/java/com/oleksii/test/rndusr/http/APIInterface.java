package com.oleksii.test.rndusr.http;

import com.oleksii.test.rndusr.models.UserResult;
import com.oleksii.test.rndusr.models.user.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIInterface {

    @GET("/api")
    Call<UserResult> getRandomUsers(@Query("results") int userCount);
}
