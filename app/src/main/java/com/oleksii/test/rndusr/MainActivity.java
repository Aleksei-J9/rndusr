package com.oleksii.test.rndusr;

import static androidx.core.util.Preconditions.checkNotNull;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.oleksii.test.rndusr.fragments.UserDataFragment;
import com.oleksii.test.rndusr.fragments.UserListFragment;
import com.oleksii.test.rndusr.interfaces.OpenUserInfoListener;
import com.oleksii.test.rndusr.models.user.User;
import com.oleksii.test.rndusr.repository.UserRepository;

public class MainActivity extends AppCompatActivity implements OpenUserInfoListener {

    private FragmentManager manager;
    private UserRepository userRepository;

    private String userListFragmentTag = "UserListFragment";
    private String userDataFragmentTag = "UserDataFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userRepository = new UserRepository();

        manager = getSupportFragmentManager();

        replaceFragment(manager, new UserListFragment(this), R.id.container, userListFragmentTag);
    }

    @Override
    public void onOpenUserInfo(User user) {
        userRepository.putUser(user);
        replaceFragment(manager, new UserDataFragment(user), R.id.container, userDataFragmentTag);
    }

    @SuppressLint("RestrictedApi")
    public void replaceFragment(@NonNull FragmentManager fragmentManager,
                                @NonNull Fragment fragment, int frameId, String tag) {

        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag(userDataFragmentTag) != null) {
            getSupportFragmentManager().popBackStack(userListFragmentTag, 0);
        } else {
            super.onBackPressed();
        }
    }
}