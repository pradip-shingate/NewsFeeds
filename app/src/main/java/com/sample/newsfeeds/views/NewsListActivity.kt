package com.sample.newsfeeds.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.newsfeeds.R
import com.sample.newsfeeds.models.NewsAdapter
import com.sample.newsfeeds.models.NewsViewModel


class NewsListActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        val recyclerView: RecyclerView = findViewById(R.id.news)

        var newsAdapter: NewsAdapter? = null

        val recycleLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = recycleLayoutManager
        val news: NewsViewModel by viewModels()
        news.news.observe(this, { article ->
            newsAdapter = NewsAdapter(news.news.value?.articles)
            recyclerView.adapter = newsAdapter
        })
    }
}