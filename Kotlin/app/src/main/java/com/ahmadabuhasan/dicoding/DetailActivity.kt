package com.ahmadabuhasan.dicoding

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail"

        imgPhoto = findViewById(R.id.img_detail_photo)
        tvName = findViewById(R.id.tv_detail_name)
        tvDetail = findViewById(R.id.tv_detail_detail)

        Glide.with(applicationContext)
            .load(intent.getIntExtra("image", 0))
            .apply(RequestOptions())
            .into(imgPhoto)
        tvName.text = intent.getStringExtra("name").toString()
        tvDetail.text = intent.getStringExtra("detail").toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}