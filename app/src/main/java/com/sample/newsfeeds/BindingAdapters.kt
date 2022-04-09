package com.sample.newsfeeds

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.newsfeeds.models.NewsAdapter

object BindingAdapters {
    @BindingAdapter("app:adapter")
    @JvmStatic fun adapter(recyclerView: RecyclerView,newsArticles: List<Article>?)
    {
        recyclerView.adapter=NewsAdapter()

    }
}