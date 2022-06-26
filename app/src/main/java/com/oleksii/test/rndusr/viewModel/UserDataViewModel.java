package com.oleksii.test.rndusr.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.oleksii.test.rndusr.models.user.User;
import com.oleksii.test.rndusr.repository.UserRepository;

public class UserDataViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    @SuppressWarnings({"FieldCanBeLocal"})
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public UserDataViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository();
    }

    public MutableLiveData<User> getUserLiveData() {
        userMutableLiveData = getUser();
        return userMutableLiveData;
    }

    private MutableLiveData<User> getUser() {
        return userRepository.getUser();
    }

}