package com.example.newsproject.ui.News

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsproject.Api.ApiManager
import com.example.newsproject.Api.Constants
import com.example.newsproject.NetworkHandler
import com.example.newsproject.database.CachNewsDataBase
import com.example.newsproject.database.MyDataBase
import com.example.newsproject.model.ArticlesItem
import com.example.newsproject.model.SourcesItem
import com.example.newsproject.repos.news.*
import com.example.newsproject.repos.sources.*
import com.example.newsproject.ui.Categories.Category
import kotlinx.coroutines.launch

class NewsViewModel:ViewModel() {

     var progressBarVisible = MutableLiveData<Boolean>()
      var sourcessLiveData = MutableLiveData<List<SourcesItem>?>()
      var articlesLiveData = MutableLiveData<List<ArticlesItem>?>()
      lateinit var newsRepository:NewsRepository
      lateinit var newsOnlinDataSource: NewsOnlinDataSource
      lateinit var sourcesRepository: SourcesRepository
      lateinit var sourcesOnlinDataSource: SourcesOnlinDataSource
      lateinit var  sourcesOfflinDataSource: SourcesOfflinDataSource
      lateinit var newsOfflineDataSource: NewsOfflineDataSource
      lateinit var networkHandler: NetworkHandler

init {

    newsOnlinDataSource = NewsOnlinDataSourceImpL(ApiManager.getApies())
    newsOfflineDataSource = NewsOfflineDataSourceImpl(CachNewsDataBase.getInstanse())
    newsRepository = NewsRepositoryImpl(newsOnlinDataSource,newsOfflineDataSource,networkHandler)

    sourcesOnlinDataSource = SourcesOnlinDataSourceImpl(ApiManager.getApies())
    sourcesOfflinDataSource = SourcesOfflinDataSourceImpl(MyDataBase.getInstanse())
    networkHandler = Constants.networkHandler
    sourcesRepository = SourcesRepositoryImpl(sourcesOnlinDataSource,sourcesOfflinDataSource,networkHandler)
}


     fun getApiSources(category: Category){
         progressBarVisible.value = true
         viewModelScope.launch {
             progressBarVisible.value = false
             try {
                 val result = sourcesRepository.getSources(category.id)
                 sourcessLiveData.value = result as List<SourcesItem>?
             }catch (ex:Exception){
                 progressBarVisible.value = false
                 throw ex
             }


        }



    }
    fun getNewsBySources(sorcesItem: SourcesItem){
        progressBarVisible.value = true
        viewModelScope.launch {
            progressBarVisible.value = false
            try {
                var result =  newsRepository.getNews(sorcesItem.id!!)
                articlesLiveData.value = result as List<ArticlesItem>?
            }catch (ex:Exception){
                progressBarVisible.value = false
                throw ex

            }


        }
    }
}