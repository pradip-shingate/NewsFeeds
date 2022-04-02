package com.sample.newsfeeds.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.newsfeeds.NewsArticles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    val news: LiveData<NewsArticles>
        get() = _news
    private val _news = MutableLiveData<NewsArticles>()

    init {
        loadNews()
    }

    private fun loadNews() {
        Thread {
            Api.client.newsList?.enqueue(object : Callback<NewsArticles?> {
                override fun onResponse(
                    call: Call<NewsArticles?>?,
                    response: Response<NewsArticles?>
                ) {
                    val data = response.body()
                    data?.let { _news.postValue(it) }
                }

                override fun onFailure(call: Call<NewsArticles?>?, t: Throwable) {

                }
            })
        }.start()
    }
}