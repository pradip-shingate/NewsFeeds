package com.sample.newsfeeds.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.newsfeeds.NewsArticles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
      var news= MutableLiveData<NewsArticles>()

    init {
        loadNews()
    }

    private fun loadNews() {
        Api.client.newsList?.enqueue(object : Callback<NewsArticles?> {
            override fun onResponse(
                call: Call<NewsArticles?>?,
                response: Response<NewsArticles?>
            ) {
                val data = response.body()
                news.postValue(data!!)
            }

            override fun onFailure(call: Call<NewsArticles?>?, t: Throwable) {

            }
        })
    }
}