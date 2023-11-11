package com.example.homework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {
    Context context1;
    List list1;
    String[] tabTitles = new String[]{"My File", "FB","DXY","ZYJ","SZF","JZC"};
    int[] avatars =new int[]{R.drawable.file, R.drawable.addrbook_2_24dp, R.drawable.message_1_24dp}; // 你的头像资源ID
    public Myadapter(Context context, List list) {
        context1 = context;
        list1 = list;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item_msg, parent, false);
        return new Myholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        String data = (String) list1.get(position);
        if (position < tabTitles.length) {
            holder.msgName.setText(tabTitles[position]); // 设置标题
        } else {
            holder.msgName.setText("Default Title"); // 如果position大于tabTitles的长度，设置一个默认标题
        }
        holder.msgContent.setText(data); // 设置内容
        if (position < avatars.length) {
            holder.avatar.setImageResource(avatars[position]); // 设置头像
        } else {
            holder.avatar.setImageResource(R.drawable.discover_3_24dp); // 如果position大于avatars的长度，设置一个默认头像
        }


holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context1, SendMessageActivity.class);
        intent.putExtra("username", tabTitles[position]);
        context1.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView msgName;
        TextView msgContent;
        ImageView avatar; // 头像
        public Myholder(@NonNull View itemView) {
            super(itemView);
            msgName = itemView.findViewById(R.id.msgName1);
            msgContent = itemView.findViewById(R.id.msgContent1);
            avatar = itemView.findViewById(R.id.avatar);
        }
    }
}