package com.example.newsproject.repos.news

import com.example.newsproject.model.ArticlesItem

interface NewsRepository {
    suspend fun getNews(sourceId:String):List<ArticlesItem?>
}
interface NewsOnlinDataSource{
    suspend fun getNews(sourceId:String?):List<ArticlesItem?>?
}
