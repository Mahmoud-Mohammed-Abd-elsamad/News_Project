package com.example.newsproject.repos.sources

import com.example.newsproject.model.SourcesItem
import com.example.newsproject.ui.Categories.Category

interface SourcesRepository {
    suspend fun getSources(category: String): List<SourcesItem?>?
}
interface SourcesOnlinDataSource{
    suspend fun getSources(category: String): List<SourcesItem?>?
}
interface SourcesOfflinDataSource{
    suspend fun getSourcesByCategory(category:String):List<SourcesItem?>

    suspend fun ubdateSources(sourcesItemList: List<SourcesItem?>?)
}