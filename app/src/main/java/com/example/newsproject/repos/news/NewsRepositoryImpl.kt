package com.example.newsproject.repos.news

import com.example.newsproject.NetworkHandler
import com.example.newsproject.model.ArticlesItem

class NewsRepositoryImpl(val newsOnlionDataSource: NewsOnlinDataSource,val newsOfflineDataSource: NewsOfflineDataSource,
        val networkHandler: NetworkHandler): NewsRepository {
    override suspend fun getNews(sourceId: String): List<ArticlesItem?>? {
        try {
            if (networkHandler.isOnlion()){
            val result = newsOnlionDataSource.getNews(sourceId)
                newsOfflineDataSource.updateNews(result)
            return result!!}
            return newsOfflineDataSource.getNews(sourceId)
        }catch (ex:Exception){
            throw ex

        }
    }
}