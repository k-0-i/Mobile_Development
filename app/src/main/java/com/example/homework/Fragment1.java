package com.example.homework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
     String [] tabTitles = new String[]{
             "发送一个机密文件",
             "我又解决了一个难题",
             "这道题太简单了",
             "我要继续学习，明天四点起床",
             "太强了",
             "好难啊"};
        list.addAll(Arrays.asList(tabTitles));
    }
}

