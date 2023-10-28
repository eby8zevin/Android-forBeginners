package com.ahmadabuhasan.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        CoinActivity detail = intent.getParcelableExtra("Send");
        String title = detail.getName();
        String info = detail.getDetail();

        getSupportActionBar().setTitle(title);

        ImageView imgPhoto = findViewById(R.id.img_photo);

        Glide.with(this)
                .load(detail.getPhoto())
                .into(imgPhoto);

        TextView tvDetail = findViewById(R.id.tv_detail);
        tvDetail.setText(info);
    }
}
