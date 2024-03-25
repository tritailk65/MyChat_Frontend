package com.example.testandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommunicationAdapter extends BaseAdapter {
    private Activity activity;
    private String[] itemcom;
    @Override
    public int getCount() {
        return itemcom.length;
    }

    @Override
    public Object getItem(int position) {
        return itemcom[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        convertView = inflater.inflate(R.layout.item_chat, null);

        // Đặt chữ cho từng view trong danh sách.
        TextView chatName = (TextView) convertView.findViewById(R.id.chat_name);
        chatName.setText(itemcom[position]);

        // Trả về view kết quả.
        return convertView;
    }
}
