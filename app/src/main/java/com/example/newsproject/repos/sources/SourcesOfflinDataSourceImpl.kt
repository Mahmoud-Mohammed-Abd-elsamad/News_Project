package com.example.newsproject.repos.sources

import com.example.newsproject.Api.WebServices
import com.example.newsproject.database.MyDataBase
import com.example.newsproject.model.SourcesItem
import com.example.newsproject.ui.Categories.Category

class SourcesOfflinDataSourceImpl( val myDataBase: MyDataBase):SourcesOfflinDataSource {
    override suspend fun getSourcesByCategory(category: String): List<SourcesItem?> {
        return myDataBase.dao_sources().getSourcesByCategory(category)
    }

    override suspend fun ubdateSources(sourcesItemList: List<SourcesItem?>?) {
        return myDataBase.dao_sources().ubdateSources(sourcesItemList)
    }




     }
