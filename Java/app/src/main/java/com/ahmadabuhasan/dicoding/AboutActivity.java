package com.ahmadabuhasan.dicoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void wa(View view) {
        String number = "6281234567890";
        String url = "https://api.whatsapp.com/send?phone=" + number;
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        whatsapp.setData(Uri.parse(url));
        startActivity(whatsapp);
    }
}