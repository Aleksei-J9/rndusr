package com.oleksii.test.rndusr.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.oleksii.test.rndusr.R;
import com.oleksii.test.rndusr.models.user.User;

public class UserDataFragment extends Fragment {

    private User user;

    private ShapeableImageView userPhoto;
    private TextView firstName;
    private TextView lastName;
    private TextView state;
    private TextView city;
    private TextView country;
    private TextView email;

    public UserDataFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_data, container, false);
        userPhoto = view.findViewById(R.id.userPhoto);
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        state = view.findViewById(R.id.state);
        city = view.findViewById(R.id.city);
        country = view.findViewById(R.id.country);
        email = view.findViewById(R.id.email);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstName.setText(user.getName().getFirst());
        lastName.setText(user.getName().getLast());
        state.setText(user.getLocation().getState());
        city.setText(user.getLocation().getCity());
        country.setText(user.getLocation().getCountry());
        email.setText(user.getEmail());
        Glide.with(userPhoto.getContext())
                .load(user.getPicture().getLarge())
                .into(userPhoto);
    }
}