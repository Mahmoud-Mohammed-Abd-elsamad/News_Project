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
                Log.e("internetonline","on"+networkHandler.isOnlion())
                    sourcesOfflinDataSource.ubdateSources(result)
                 return result
            }else {
                val result = sourcesOfflinDataSource.getSourcesByCategory(category)
                Log.e("internetof", "off" + networkHandler.isOnlion())
                Log.e(
                    "sourcesOfflinDataSource",
                    "" + sourcesOfflinDataSource.getSourcesByCategory(category)
                )
            return result}
        }catch (ex:Exception){
            Log.e("internetof","exswp"+networkHandler.isOnlion())
            return sourcesOfflinDataSource.getSourcesByCategory(category)
        }
    }
}