package com.example.newsproject.repos.sources

import com.example.newsproject.Api.Constants
import com.example.newsproject.Api.WebServices
import com.example.newsproject.model.SourcesItem
import com.example.newsproject.ui.Categories.Category

class SourcesOnlinDataSourceImpl(val webServices: WebServices):SourcesOnlinDataSource {
    override suspend fun getSources(category:String): List<SourcesItem?>? {
        try {
            val result = webServices.getServices(Constants.Apikey, category)
            return result.sources
        }catch (ex:Exception){
            throw ex
        }

    }
}