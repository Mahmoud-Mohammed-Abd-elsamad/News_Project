package com.example.newsproject.database

import androidx.room.*
import com.example.newsproject.model.SourcesItem
import com.example.newsproject.ui.Categories.Category

@Dao
interface SourcesDao{
    @Query ("select * from SourcesItem")
  suspend fun getSources():List<SourcesItem?>
    @Query ("select * from SourcesItem where category=:category")
  suspend fun getSourcesByCategory(category:String):List<SourcesItem>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun ubdateSources(sourcesItem: List<SourcesItem?>?)



}