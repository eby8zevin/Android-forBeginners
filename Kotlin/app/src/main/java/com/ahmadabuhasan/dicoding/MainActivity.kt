package com.ahmadabuhasan.dicoding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvLanguage: RecyclerView
    private var list: ArrayList<Language> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLanguage = findViewById(R.id.rv_programmingLanguages)
        rvLanguage.setHasFixedSize(true)

        list.addAll(LanguagesData.listData)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = ListAdapter(list)
        rvLanguage.adapter = adapter
        rvLanguage.layoutManager = layoutManager
        rvLanguage.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )

        adapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Language) {
                val i = Intent(this@MainActivity, DetailActivity::class.java)
                i.putExtra("image", data.image)
                i.putExtra("name", data.name)
                i.putExtra("detail", data.detail)
                i.putExtra("skill", data.skill)
                i.putExtra("link", data.link)
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
        } else if (item.itemId == R.id.about) {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}