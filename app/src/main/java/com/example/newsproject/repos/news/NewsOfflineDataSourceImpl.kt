package com.example.newsproject.repos.news

import com.example.newsproject.database.CachNewsDataBase
import com.example.newsproject.model.ArticlesItem

class NewsOfflineDataSourceImpl(val cachNewsDataBase:CachNewsDataBase):NewsOfflineDataSource {
    override suspend fun getNews(sourceId: String?): List<ArticlesItem?>? {
        return cachNewsDataBase.dao_news().getNews()
    }

    override suspend fun updateNews(list: List<ArticlesItem?>?) {
        return cachNewsDataBase.dao_news().ubdateSources(list)    }
}