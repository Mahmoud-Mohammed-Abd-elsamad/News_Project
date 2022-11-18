package com.example.newsproject.ui.News

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.Api.ApiManager
import com.example.newsproject.Api.Cnstants
import com.example.newsproject.R
import com.example.newsproject.model.Category
import com.example.newsproject.model.NewsResponse
import com.example.newsproject.model.SourcesItem
import com.example.newsproject.model.SourcesResponse
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFragment : Fragment() {

    companion object{
        fun getinstanse(category: Category):NewsFragment{
           val fragment = NewsFragment()
            fragment.category = category
            return fragment
        }
    }
    lateinit var category: Category
    lateinit var tapLayout:TabLayout
    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsAdapter
    lateinit var list: List<NewsAdapter>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tapLayout = view.findViewById(R.id.tabLayout)
        progressBar =view. findViewById(R.id.progress_bar)
        adapter =  NewsAdapter(null)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter

        getApiSources()
        tapLayout.getTabAt(0)?.select()
        tapLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var source = tab?.tag as SourcesItem   //<<<<<<<<<<<<<<
                getNewsBySources(source )
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var source = tab?.tag as SourcesItem   //<<<<<<<<<<<<<<
                getNewsBySources(source )
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                var sources = tab?.tag
                getNewsBySources(sources as SourcesItem)
            }

        })
    }

    private fun getApiSources() {
        progressBar.isVisible = true
        ApiManager.getApies().getServices(Cnstants.Apikey,category.id)
            .enqueue(object: Callback<SourcesResponse> {
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    progressBar.isVisible = false
                    addSourcesToTablayout(response.body()?.sources)

                }

                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                    progressBar.isVisible = false

                }

            })
    }

    private fun addSourcesToTablayout(sources: List<SourcesItem?>?){

        sources?.forEach {
            var tab = tapLayout.newTab()
            tab.text=(it?.name)
            tab.tag = it                     //<<<<<<<<<<<<<<<<
            tapLayout.addTab(tab)
        }
    }

    private fun getNewsBySources(sources: SourcesItem) {
        progressBar.isVisible = true
        ApiManager.getApies().getNews(Cnstants.Apikey, sources.id!!)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    progressBar.isVisible = false
                    adapter.DataChanged(response.body()?.articles)
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    progressBar.isVisible = false
                }

            })
    }


}
