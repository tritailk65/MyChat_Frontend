package com.example.testandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CallListAdapter extends BaseAdapter {
    private Activity activity;
    private String[] itemcall;

    public CallListAdapter(String[] itemcall,Activity activity){
        this.activity = activity;
        this.itemcall=itemcall;
    }
    @Override
    public int getCount() {
        return itemcall.length;
    }

    @Override
    public Object getItem(int position) {
        return itemcall[position];
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
        convertView = inflater.inflate(R.layout.item_call, null);

        // Đặt chữ cho từng view trong danh sách.
        TextView chatName = (TextView) convertView.findViewById(R.id.call_name);
        chatName.setText(itemcall[position]);

        // Trả về view kết quả.
        return convertView;
    }
}
