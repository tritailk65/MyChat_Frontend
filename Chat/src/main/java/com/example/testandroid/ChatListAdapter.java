package com.example.testandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChatListAdapter extends BaseAdapter {
    private Activity activity;
    private String[] chat_Name;
    private String[] chat_Content;
    private String[] chat_Date;
    public ChatListAdapter(String[] chat_Name,Activity activity,String[] chat_Content,String[] chat_Date){
        this.activity = activity;
        this.chat_Name=chat_Name;
        this.chat_Content=chat_Content;
        this.chat_Date=chat_Date;
    }
    @Override
    public int getCount() {
        return chat_Name.length;
    }

    @Override
    public Object getItem(int position) {
        return chat_Name[position];
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
        TextView chatContent = (TextView) convertView.findViewById(R.id.chat_content);
        TextView chatDate = (TextView) convertView.findViewById(R.id.chat_date);
        chatName.setText(chat_Name[position]);
        chatContent.setText(chat_Content[position]);
        chatDate.setText(chat_Date[position]);

        // Trả về view kết quả.
        return convertView;
    }

}
