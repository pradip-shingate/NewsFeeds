package com.sample.newsfeeds.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sample.newsfeeds.Article
import com.sample.newsfeeds.R

class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var dataset= mutableListOf<Article>()

    fun setArticles(data:List<Article>)
    {
        this.dataset=data.toMutableList()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imageView)
            .apply { RequestOptions().override(520, 293) }
            .load(dataset?.get(position)?.urlToImage)
            .centerInside()
            .into(holder.imageView)
        holder.title.text= dataset?.get(position)?.title
        holder.description.text=dataset?.get(position)?.description
    }

    override fun getItemCount(): Int {
        return dataset?.let { return it.size } ?: return 0
    }
}