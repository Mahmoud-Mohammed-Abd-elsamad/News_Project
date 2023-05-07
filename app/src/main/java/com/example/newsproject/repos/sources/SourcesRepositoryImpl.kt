package com.example.newsproject.repos.sources

import android.util.Log
import com.example.newsproject.NetworkHandler
import com.example.newsproject.model.SourcesItem
import com.example.newsproject.ui.Categories.Category

class SourcesRepositoryImpl(val sourcesOnlinDataSource: SourcesOnlinDataSource,
        val sourcesOfflinDataSource: SourcesOfflinDataSource,val networkHandler:NetworkHandler):SourcesRepository {
    override suspend fun getSources(category: String): List<SourcesItem?>? {
        try {
            if (networkHandler.isOnlion()) {
                   val result = sourcesOnlinDataSource.getSources(category)
                Log.e("internetonline",""+networkHandler.isOnlion())
                    sourcesOfflinDataSource.ubdateSources(result)
                 return result
            }
            val result = sourcesOfflinDataSource.getSourcesByCategory(category)
            Log.e("internet of",""+networkHandler.isOnlion())
            Log.e("sourcesOfflinDataSource",""+sourcesOfflinDataSource.getSourcesByCategory(category))
            return result
        }catch (ex:Exception){
            throw ex
        }
    }
}