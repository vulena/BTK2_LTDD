package com.ltdd.bktso2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private List<Member> items;

    public Adapter(Activity activity, List<Member> items) {
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_item, null);
        TextView tvtenkh = (TextView) view.findViewById(R.id.tv_namei);
        TextView tvtenthuonggoi = (TextView) view.findViewById(R.id.tv_nicknamei);
        TextView tvdactinh = (TextView) view.findViewById(R.id.tv_dactinhi);
        TextView tvcongdung = (TextView) view.findViewById(R.id.tv_congdungi);
        TextView tvlieudung = (TextView) view.findViewById(R.id.tv_lieudungi);
        TextView tvluuy = (TextView) view.findViewById(R.id.tv_luuyi);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgHinh);
        tvtenkh.setText(items.get(i).getTenkhoahoc());
        tvtenthuonggoi.setText(items.get(i).getTenthuonggoi());
        tvdactinh.setText(items.get(i).getDactinh());
        tvcongdung.setText(String.valueOf(items.get(i).getCongdung()));
        tvlieudung.setText(items.get(i).getLieudung());
        tvluuy.setText(items.get(i).getLuuy());
        imageView.setImageResource(items.get(i).getHinhAnh());
        return view;
    }
}
