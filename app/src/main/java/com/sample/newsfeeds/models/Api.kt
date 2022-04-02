package com.sample.newsfeeds.models

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object Api {
    private var retrofit: Retrofit? = null

    // change your base URL
    //Creating object for our interface
    val client: ApiInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            //Creating object for our interface
            return retrofit!!.create(ApiInterface::class.java) // return the APIInterface object
        }
}