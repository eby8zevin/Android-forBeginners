package com.ahmadabuhasan.dicoding.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ahmadabuhasan.dicoding.R
import com.ahmadabuhasan.dicoding.databinding.ActivityDetailBinding
import com.ahmadabuhasan.dicoding.model.Language
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var dataShare: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_data", Language::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_data")
        }

        if (supportActionBar != null) {
            supportActionBar?.title = "Detail ${data?.name}"
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        if (data != null) {
            Glide.with(applicationContext)
                .load(data.image)
                .apply(RequestOptions())
                .into(binding.imgDetailPhoto)

            binding.tvDetailName.text = data.name
            binding.tvDetailDetail.text = data.detail
            binding.tvDetailSkill.text = data.skill

            binding.btnDetailLink.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
                startActivity(i)
            }

            dataShare = data.detail
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, dataShare)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)

                return true
            }

            android.R.id.home -> {
                finish()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}