package com.example.newsproject.Api

import com.example.newsproject.model.NewsResponse
import com.example.newsproject.model.SourcesResponse
import com.example.newsproject.ui.Categories.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("v2/top-headlines/sources")
    suspend fun getServices(
        @Query("apiKey")
        apiKey:String,
        @Query("category")
        category: String
    ): SourcesResponse

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apiKey :String,
        @Query("sources") sources:String

    ):NewsResponse

}