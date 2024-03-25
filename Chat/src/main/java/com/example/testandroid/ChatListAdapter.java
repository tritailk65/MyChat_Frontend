package com.example.testandroid;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChatListAdapter extends BaseAdapter {
    private Activity activity;
    private String[] itemchat;

    public ChatListAdapter(String[] itemchat,Activity activity){
        this.activity = activity;
        this.itemchat=itemchat;
    }
    @Override
    public int getCount() {
        return itemchat.length;
    }

    @Override
    public Object getItem(int position) {
        return itemchat[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        convertView = inflater.inflate(R.layout.item_chat, null);
        // Đặt chữ cho từng view trong danh sách.
        TextView chatName = (TextView) convertView.findViewById(R.id.chat_name);
        chatName.setText(itemchat[position]);

        // Trả về view kết quả.
        return convertView;
    }

}
