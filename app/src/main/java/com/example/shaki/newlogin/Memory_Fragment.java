package com.example.shaki.newlogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Memory_Fragment extends Fragment {
    private Button addMemory;

    private EditText description;

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memory_, container, false);

        imageView =  view.findViewById(R.id.image);

        description = view.findViewById(R.id.description);

        addMemory =  view.findViewById(R.id.addMemory);

        addMemory.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

            }

        });

        return view;

    }

}
