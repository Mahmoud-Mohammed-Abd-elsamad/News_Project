package com.example.newsproject.Api

import com.example.newsproject.model.NewsResponse
import com.example.newsproject.model.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebSevices {
    @GET("v2/top-headlines/sources")
    fun getServices(
        @Query("apiKey")
        apiKey :String ,
        @Query("category")
        category:String
    ): Call<SourcesResponse>

    @GET("v2/everything")
    fun getNews(
        @Query("apiKey") apiKey :String,
        @Query("sources") sources:String

    ): Call<NewsResponse>

}