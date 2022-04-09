package com.sample.newsfeeds.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.newsfeeds.R
import com.sample.newsfeeds.databinding.ActivityNewsListBinding
import com.sample.newsfeeds.models.NewsAdapter
import com.sample.newsfeeds.models.NewsViewModel


class NewsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_list)
        val news: NewsViewModel by viewModels()
        binding.viewModel = news
        val adapter=NewsAdapter()
        binding.news.adapter=adapter
        news.news.observe(this,{data->
            adapter.setArticles(data)
        })
    }
}