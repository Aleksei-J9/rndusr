package com.oleksii.test.rndusr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.oleksii.test.rndusr.interfaces.ItemClickListener;
import com.oleksii.test.rndusr.models.user.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<User> users;
    private ItemClickListener clickListener;
    private Context context;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.firstName.setText(user.getName().getFirst());
        holder.lastName.setText(user.getName().getLast());
        holder.title.setText(user.getName().getTitle());
        Glide.with(holder.userPhotoThumbnail.getContext())
                .load(user.getPicture().getThumbnail())
                .into(holder.userPhotoThumbnail);
        holder.clickListener = this.clickListener;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView firstName, lastName, title;
        final ImageView userPhotoThumbnail;
        private ItemClickListener clickListener;

        ViewHolder(View view) {
            super(view);
            firstName = view.findViewById(R.id.firstName);
            lastName = view.findViewById(R.id.lastName);
            title = view.findViewById(R.id.title);

            userPhotoThumbnail = view.findViewById(R.id.userPhotoThumbnail);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

}