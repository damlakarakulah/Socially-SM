package com.app4a.sm.adapter;


import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app4a.sm.R;
import com.app4a.sm.db.Post;
import com.app4a.sm.utils.Config;

import java.util.ArrayList;
import java.util.List;

public class HomePostAdapter extends RecyclerView.Adapter<HomePostAdapter.HomePostHolder> {
    private Context context;
    private List<Post> postList = new ArrayList<>();
    public static HomePostAdapter self;

    public HomePostAdapter(Context context, List<Post> postList){
        this.context = context;
        this.postList = postList;
        self = this;
    }

    public void update(List<Post> newsList){
        this.postList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomePostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomePostHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomePostHolder holder, int position) {
        holder.imageView.setImageDrawable(Config.imageSrcToDrawable(context,postList.get(position).getImageUrl()));
        holder.imageViewProfile.setImageDrawable(Config.imageSrcToDrawable(context,postList.get(position).getUser().getProfilePicture()));
        holder.name.setText(postList.get(position).getUser().getName());
        holder.date.setText(postList.get(position).getDate());
        holder.saves.setText(postList.get(position).getSaves());
        holder.comments.setText(postList.get(position).getComments());
        holder.likes.setText(postList.get(position).getLikes());

        //Glide.with(context).load(postList.get(position).getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    public static class HomePostHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private ImageView imageViewProfile;
        private TextView name;
        private TextView date;
        private TextView comments;
        private TextView likes;
        private TextView saves;

        public HomePostHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewHome);
            imageViewProfile = itemView.findViewById(R.id.profile_image_home);
            name = itemView.findViewById(R.id.name_home);
            date = itemView.findViewById(R.id.date_home);
            comments = itemView.findViewById(R.id.comments);
            likes = itemView.findViewById(R.id.likes);
            saves = itemView.findViewById(R.id.saves);
        }
    }
}
