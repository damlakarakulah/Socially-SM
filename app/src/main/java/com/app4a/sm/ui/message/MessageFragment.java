package com.app4a.sm.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app4a.sm.R;

public class MessageFragment extends Fragment {


    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_message, container, false);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}