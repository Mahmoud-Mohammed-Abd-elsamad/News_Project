package com.example.newsproject.repos.news

import com.example.newsproject.model.ArticlesItem

class NewsRepositoryImpl(val newsOnlionDataSource: NewsOnlinDataSource): NewsRepository {
    override suspend fun getNews(sourceId: String): List<ArticlesItem?> {
        try {
            val result = newsOnlionDataSource.getNews(sourceId)
            return result!!
        }catch (ex:Exception){
            throw ex
        }
    }
}