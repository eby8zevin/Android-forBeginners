package com.ahmadabuhasan.dicoding.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadabuhasan.dicoding.R
import com.ahmadabuhasan.dicoding.adapter.ListAdapter
import com.ahmadabuhasan.dicoding.data.LanguagesData
import com.ahmadabuhasan.dicoding.databinding.ActivityMainBinding
import com.ahmadabuhasan.dicoding.model.Language

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<Language> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(LanguagesData.listData)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        binding.rvProgrammingLanguages.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProgrammingLanguages.layoutManager = layoutManager
        val adapter = ListAdapter(list)
        binding.rvProgrammingLanguages.adapter = adapter

        adapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Language) {
                val i = Intent(this@MainActivity, DetailActivity::class.java)
                i.putExtra("key_data", data)
                startActivity(i)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.source) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.simplilearn.com/best-programming-languages-start-learning-today-article")
                )
            )
        } else if (item.itemId == R.id.about_page) {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}