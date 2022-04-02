package com.sample.newsfeeds.models

import com.sample.newsfeeds.NewsArticles
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    // for GET request
    // API's endpoints
    @get:GET("top-headlines?country=us&category=business&apiKey=92dc2b9444d948b9bf01e59a20946192")
    val newsList: Call<NewsArticles?>?
}