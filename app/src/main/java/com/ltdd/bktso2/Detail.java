package com.ltdd.bktso2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textViewten = (TextView)findViewById(R.id.thongtin_ten);
        TextView textViewmota = (TextView) findViewById(R.id.thongtin_chitiet);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = (ImageView) findViewById(R.id.thongtin_hinh);
        Intent intent= getIntent();
        textViewten.setText(intent.getStringExtra("Ten"));
        textViewmota.setText(intent.getStringExtra("MoTa"));
        imageView.setImageResource(intent.getIntExtra("hinhanh",R.drawable.ic_launcher_background));
    }
}