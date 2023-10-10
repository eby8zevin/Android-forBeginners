package com.ahmadabuhasan.dicoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmadabuhasan.dicoding.model.Language
import com.ahmadabuhasan.dicoding.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAdapter(private val listLanguage: ArrayList<Language>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_language, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val language = listLanguage[position]

        Glide.with(holder.itemView.context)
            .load(language.image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = language.name
        holder.tvDetail.text = language.detail

        holder.itemView.setOnClickListener {
            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listLanguage[holder.absoluteAdapterPosition]) }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Language)
    }

    override fun getItemCount(): Int {
        return listLanguage.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
    }
}