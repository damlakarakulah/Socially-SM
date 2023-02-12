package com.app4a.sm.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app4a.sm.R;
import com.app4a.sm.adapter.PostAdapter;
import com.app4a.sm.db.Post;
import com.app4a.sm.db.User;
import com.app4a.sm.utils.Config;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private View view;
    private User mainUser;
    private TextView name;
    private TextView userName;
    private ImageView profilePicture;
    private TextView postNumber;
    private TextView follows;
    private TextView followers;
    Gson gson = new Gson();
    private List<Post> posts = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        name = view.findViewById(R.id.name);
        userName = view.findViewById(R.id.userName);
        profilePicture = view.findViewById(R.id.profilePicture);
        follows = view.findViewById(R.id.follows);
        followers = view.findViewById(R.id.followers);
        postNumber = view.findViewById(R.id.posts);
        recyclerView = view.findViewById(R.id.recycler);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUsers();
        mainUser = Config.getMainUser(getActivity());
        name.setText(mainUser.getName());
        userName.setText(mainUser.getUsername());
        profilePicture.setImageDrawable(Config.imageSrcToDrawable(getActivity(),mainUser.getProfilePicture()));
        followers.setText(String.valueOf(Config.getFollowers(getActivity())));
        follows.setText(String.valueOf(Config.getFollowings(getActivity())));
        postNumber.setText(String.valueOf(mainUser.getPosts().size()));
        posts = mainUser.getPosts();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        postAdapter = new PostAdapter(getActivity(),posts);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void getUsers(){
        String newsStr = Config.getSPreferences(getActivity()).getUsers();
        if(newsStr.equals("")){
            users = Config.getObjectList(getActivity(),"users.txt", User[].class);
            Config.getSPreferences(getActivity()).setUsers(gson.toJson(users));
        }
        else{
            users = Config.getObjectList(newsStr, User[].class);
            System.out.println(users);
        }
    }
}