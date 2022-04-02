package com.sample.newsfeeds

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
class Source {
    @SerializedName("id")
    @Expose
    var id: Any? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}