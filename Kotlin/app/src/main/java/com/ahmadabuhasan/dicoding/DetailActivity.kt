package com.ahmadabuhasan.dicoding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDetail: TextView
    private lateinit var tvSkill: TextView
    private lateinit var btnLink: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imgPhoto = findViewById(R.id.img_detail_photo)
        tvName = findViewById(R.id.tv_detail_name)
        tvDetail = findViewById(R.id.tv_detail_detail)
        tvSkill = findViewById(R.id.tv_detail_skill)
        btnLink = findViewById(R.id.btn_detail_link)

        Glide.with(applicationContext)
            .load(intent.getIntExtra("image", 0))
            .apply(RequestOptions())
            .into(imgPhoto)

        val name = intent.getStringExtra("name").toString()
        val detail = intent.getStringExtra("detail").toString()
        val skill = intent.getStringExtra("skill").toString()
        val link = intent.getStringExtra("link").toString()

        tvName.text = name
        tvDetail.text = detail
        tvSkill.text = skill

        btnLink.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(i)
        }

        supportActionBar?.title = "Detail $name"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite) {
            if (item.isChecked) {
                item.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
                Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show()
                item.isChecked = false
            } else {
                item.icon = ContextCompat.getDrawable(this, R.drawable.ic_unfavorite)
                Toast.makeText(this, "UnLike", Toast.LENGTH_SHORT).show()
                item.isChecked = true
            }
            return true
        } else if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}