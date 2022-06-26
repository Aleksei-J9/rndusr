package com.oleksii.test.rndusr.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oleksii.test.rndusr.R;
import com.oleksii.test.rndusr.UserAdapter;
import com.oleksii.test.rndusr.interfaces.ItemClickListener;
import com.oleksii.test.rndusr.interfaces.OpenUserInfoListener;
import com.oleksii.test.rndusr.models.user.User;
import com.oleksii.test.rndusr.viewModel.UserListViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends Fragment implements ItemClickListener {

    private List<User> userList = new ArrayList<>();
    private UserAdapter adapter;
    private RecyclerView recyclerView;
    private UserListViewModel userListViewModel;
    private OpenUserInfoListener openUserInfoListener;

    public UserListFragment(OpenUserInfoListener openUserInfoListener) {
        this.openUserInfoListener = openUserInfoListener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        recyclerView = view.findViewById(R.id.list);
        setupRecyclerView(requireContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        userListViewModel.getUserLiveData(20).observe(getViewLifecycleOwner(), users -> {
            userList.addAll(users);
            adapter.notifyDataSetChanged();
        });
    }

    private void setupRecyclerView(Context context) {
        adapter = new UserAdapter(context, userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        adapter.setClickListener(this::onClick);
    }

    @Override
    public void onClick(View view, int position) {
        User user = userList.get(position);
        if (openUserInfoListener != null) openUserInfoListener.onOpenUserInfo(user);
    }
}