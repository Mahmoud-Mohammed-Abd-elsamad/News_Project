package com.example.newsproject.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SourcesResponse(

	@field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)
@Entity
data class SourcesItem(
@ColumnInfo
	@field:SerializedName("country")
	val country: String? = null,
@ColumnInfo
	@field:SerializedName("name")
	val name: String? = null,
@ColumnInfo
	@field:SerializedName("description")
	val description: String? = null,
@ColumnInfo
	@field:SerializedName("language")
	val language: String? = null,
@PrimaryKey
@NonNull
@ColumnInfo
	@field:SerializedName("id")
	val id: String,
@ColumnInfo
	@field:SerializedName("category")
	val category: String,
@ColumnInfo
	@field:SerializedName("url")
	val url: String? = null
)
