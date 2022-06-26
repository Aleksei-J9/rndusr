package com.oleksii.test.rndusr.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.oleksii.test.rndusr.http.APIClient;
import com.oleksii.test.rndusr.http.APIInterface;
import com.oleksii.test.rndusr.models.UserResult;
import com.oleksii.test.rndusr.models.user.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListRemoteRepository {
    private APIInterface apiInterface;
    private MutableLiveData<List<User>> usersLiveData = new MutableLiveData<>();

    private static UserListRemoteRepository userRemoteRepository;

    public static UserListRemoteRepository getInstance() {
        if (userRemoteRepository == null) {
            userRemoteRepository = new UserListRemoteRepository();
        }
        return userRemoteRepository;
    }

    public UserListRemoteRepository() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    public MutableLiveData<List<User>> getUserList(int userCount) {
        Call<UserResult> call = apiInterface.getRandomUsers(userCount);
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                usersLiveData.setValue(response.body().getUsers());
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                call.cancel();
                usersLiveData.setValue(null);
                Log.e("get FAIL", t.getMessage());
            }
        });
        return usersLiveData;
    }

}

