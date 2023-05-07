package com.example.newsproject.ui.News

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.R
import com.example.newsproject.databinding.FragmentNewsBinding
import com.example.newsproject.ui.Categories.Category
import com.example.newsproject.model.SourcesItem
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch


class NewsFragment : Fragment() {

    companion object{
        fun getinstanse(category: Category):NewsFragment{
           val fragment = NewsFragment()
            fragment.category = category
            return fragment
        }
    }
    lateinit var viewModel: NewsViewModel
    lateinit var category: Category
    lateinit var tapLayout:TabLayout
    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsAdapter
    lateinit var list: List<NewsAdapter>
    lateinit var binding: FragmentNewsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_news, container, false)

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



             adapter =  NewsAdapter(null)
        binding.recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        subScribeToliveData()


        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                 viewModel.getApiSources(category)

            }
        }

        binding.tabLayout.getTabAt(0)?.select()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var source = tab?.tag as SourcesItem   //<<<<<<<<<<<<<<
                viewModel.getNewsBySources(source)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var source = tab?.tag as SourcesItem   //<<<<<<<<<<<<<<
                viewModel.getNewsBySources(source)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                var sources = tab?.tag
                viewModel.getNewsBySources(sources as SourcesItem)
            }

        })
    }

    private fun subScribeToliveData() {
        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer { it->
       binding.progressBar.isVisible = it
        })

        viewModel.sourcessLiveData.observe(viewLifecycleOwner, Observer { Data->
            addSourcesToTablayout(Data)
        })
        viewModel.articlesLiveData.observe(viewLifecycleOwner, Observer { Data->
            adapter.DataChanged(Data)

        })
    }


    private fun addSourcesToTablayout(sources: List<SourcesItem?>?){

        sources?.forEach {
            var tab = binding.tabLayout.newTab()
            tab.text=(it?.name)
            tab.tag = it                     //<<<<<<<<<<<<<<<<
            binding.tabLayout.addTab(tab)
        }
    }



}
