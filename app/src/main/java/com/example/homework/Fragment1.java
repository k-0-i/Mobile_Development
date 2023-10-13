package com.example.homework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Fragment1 extends Fragment {
    RecyclerView recyclerView;
    Myadapter adapter;
    List<String> list;
    Context context;

    //    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        context = view.getContext();
        recyclerView = view.findViewById(R.id.tab1);
        list = new ArrayList<String>();
        initData();
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new Myadapter(context, list);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        return view;


    }

    private void initData() {
        for (int i = 0; i < 9; i++) {
            list.add("这是第" + i + "行数据          ");
        }
    }

}

