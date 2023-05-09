package com.example.newsproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ArticlesItemModel(
    @ColumnInfo
    @field:SerializedName("publishedAt")
    val publishedAt: String? = null,
    @ColumnInfo
    @field:SerializedName("author")
    val author: String? = null,
    @ColumnInfo
    @field:SerializedName("urlToImage")
    val urlToImage: ByteArray? = null,//>>>
    @ColumnInfo
    @field:SerializedName("description")
    val description: String? = null,
    @field:SerializedName("source")
    val source: Source? = null,
    @PrimaryKey
    @ColumnInfo
    @field:SerializedName("title")
    val title: String,
    @ColumnInfo
    @field:SerializedName("url")
    val url: String? = null,
    @ColumnInfo
    @field:SerializedName("content")
    val content: String? = null)
@Entity
data class SourceItem(
@ColumnInfo
    @field:SerializedName("name")
    val name: String? = null,
@ColumnInfo
@PrimaryKey
    @field:SerializedName("id")
    val id: String? = null
)