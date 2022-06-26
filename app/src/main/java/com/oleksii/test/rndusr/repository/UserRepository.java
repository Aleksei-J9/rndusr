package com.oleksii.test.rndusr.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.oleksii.test.rndusr.http.APIClient;
import com.oleksii.test.rndusr.http.APIInterface;
import com.oleksii.test.rndusr.models.UserResult;
import com.oleksii.test.rndusr.models.user.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private APIInterface apiInterface;
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    private static UserRepository userRemoteRepository;

    public static UserRepository getInstance() {
        if (userRemoteRepository == null) {
            userRemoteRepository = new UserRepository();
        }
        return userRemoteRepository;
    }

    public UserRepository() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    public void putUser(User newUser) {
        userMutableLiveData.setValue(newUser);
    }

    public MutableLiveData<User> getUser(){
        return userMutableLiveData;
    }

}

