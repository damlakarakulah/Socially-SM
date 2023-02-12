package com.app4a.sm.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app4a.sm.R;
import com.app4a.sm.adapter.HomePostAdapter;
import com.app4a.sm.adapter.PostAdapter;
import com.app4a.sm.db.Post;
import com.app4a.sm.utils.Config;

import java.util.List;

public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Post> postList;
    private HomePostAdapter postAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recViewHome);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postList = Config.getAllPosts(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        postAdapter = new HomePostAdapter(getActivity(),postList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);


    }
}
