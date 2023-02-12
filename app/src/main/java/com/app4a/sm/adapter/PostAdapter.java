package com.app4a.sm.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app4a.sm.R;
import com.app4a.sm.db.Post;
import com.app4a.sm.utils.Config;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private Context context;
    private List<Post> postList = new ArrayList<>();
    public static PostAdapter self;

    public PostAdapter(Context context, List<Post> postList){
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
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_profile, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.imageView.setImageDrawable(Config.imageSrcToDrawable(context,postList.get(position).getImageUrl()));
        //Glide.with(context).load(postList.get(position).getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    public static class PostHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
