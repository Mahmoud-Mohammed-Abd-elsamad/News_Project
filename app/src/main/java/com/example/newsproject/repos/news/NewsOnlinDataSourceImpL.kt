package com.example.newsproject.repos.news

import com.example.newsproject.Api.Constants
import com.example.newsproject.Api.WebServices
import com.example.newsproject.model.ArticlesItem

class NewsOnlinDataSourceImpL(val webServices: WebServices): NewsOnlinDataSource {

    override suspend fun getNews(sourceId: String?): List<ArticlesItem?>? {
try {


        val result = webServices.getNews(Constants.Apikey, sourceId!!)
        return result.articles
    }catch (ex:Exception){
        throw ex

    }
    }
}