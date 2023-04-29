package com.example.newsproject.ui.News

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsproject.R
import com.example.newsproject.databinding.FragmentNewsBinding
import com.example.newsproject.databinding.ItemNewsBinding
import com.example.newsproject.model.ArticlesItem

class NewsAdapter(var items:List<ArticlesItem>?): RecyclerView.Adapter<NewsAdapter.viewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding:ItemNewsBinding = DataBindingUtil
            .inflate(LayoutInflater.from(parent.context),R.layout.item_news,parent,false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var item = items?.get(position)
        holder.bind(item!!)
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }

    fun DataChanged(newItems:List<ArticlesItem?>?){
        items = newItems as List<ArticlesItem>?
        notifyDataSetChanged()

    }

    class viewHolder(var itemBinding:ItemNewsBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item:ArticlesItem){
            itemBinding.item = item
            itemBinding.invalidateAll()
        }


    }
}