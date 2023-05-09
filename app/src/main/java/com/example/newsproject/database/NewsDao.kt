package com.example.newsproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsproject.model.ArticlesItem
import com.example.newsproject.model.SourcesItem

@Dao
interface NewsDao{
    @Query("select * from ArticlesItemModel")
    suspend fun getNews():List<ArticlesItem?>
    @Query("select * from ArticlesItemModel where source=:source")
    suspend fun getSourcesByCategory(source:String):List<SourcesItem>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun ubdateSources(sources: List<ArticlesItem?>?)



}