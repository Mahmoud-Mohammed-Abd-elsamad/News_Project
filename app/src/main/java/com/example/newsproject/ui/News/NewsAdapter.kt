package com.example.newsproject.ui.News

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsproject.R
import com.example.newsproject.model.ArticlesItem

class NewsAdapter(var items:List<ArticlesItem>?): RecyclerView.Adapter<NewsAdapter.viewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var item = items?.get(position)
        holder.auther.text = item?.author
        holder.title.text = item?.title
        holder.date.text = item?.publishedAt
        Glide.with(holder.itemView).load(item?.url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }

    fun DataChanged(newItems:List<ArticlesItem?>?){
        items = newItems as List<ArticlesItem>?
        notifyDataSetChanged()

    }

    class viewHolder(var itemview: View): RecyclerView.ViewHolder(itemview){
        var image = itemview.findViewById<ImageView>(R.id.image)
        var title = itemview.findViewById<TextView>(R.id.title)
        var auther = itemview.findViewById<TextView>(R.id.auther)
        var date = itemview.findViewById<TextView>(R.id.date)
       // var item_progressBar = itemview.findViewById<ProgressBar>(R.id.item_prgressBar)

    }
}