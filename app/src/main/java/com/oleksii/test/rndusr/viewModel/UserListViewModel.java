package com.oleksii.test.rndusr.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.oleksii.test.rndusr.models.user.User;
import com.oleksii.test.rndusr.repository.UserListRemoteRepository;

import java.util.List;

public class UserListViewModel extends AndroidViewModel {

    private UserListRemoteRepository userRemoteRepository;

    @SuppressWarnings({"FieldCanBeLocal"})
    private MutableLiveData<List<User>> usersLiveData = new MutableLiveData<>();
    public UserListViewModel(@NonNull Application application) {
        super(application);
        userRemoteRepository = new UserListRemoteRepository();
    }
    public MutableLiveData<List<User>> getUserLiveData(int userCount) {
        usersLiveData = loadUserList(userCount);
        return usersLiveData;
    }
    private MutableLiveData<List<User>> loadUserList(int userCount) {
        return userRemoteRepository.getUserList(userCount);
    }
}