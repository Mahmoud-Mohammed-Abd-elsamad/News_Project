package com.example.newsproject.ui.Categories

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.R
import com.google.android.material.card.MaterialCardView

class CategoryAdapter(val list: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(
            if (viewType == LIFT_ITEM_VIEW) R.layout.right_item_category
            else R.layout.lift_item_category, parent, false
        )

        return CategoryViewHolder(view)
    }

    var RIHT_ITEM_VIEW = 10
    var LIFT_ITEM_VIEW = 20
    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) LIFT_ITEM_VIEW else RIHT_ITEM_VIEW
        //************************************
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var category = list.get(position)

        holder.title_id.setText(category.id)
        holder.image_id.setImageResource(category.imageId)
        holder.card_view.setCardBackgroundColor(
            ContextCompat.getColor(
                holder.itemView.context,
                category.backGroundid //**************
            )
        )


        onClicLisnerInterface.let {
              holder.itemView.setOnClickListener {

                  onClicLisnerInterface?.onItemclic(position,category)
                  Log.e("OnClicOnADAPTERCATEGORY","DONE 1")
              }

            }
        }



    override fun getItemCount(): Int {
        return list.size
    }

    var onClicLisnerInterface: OnClicLisnerInterface? = null

    interface OnClicLisnerInterface {
         fun onItemclic(position: Int,category: Category)
    }

    class CategoryViewHolder(iteview: View) : RecyclerView.ViewHolder(iteview) {
        var title_id = iteview.findViewById<TextView>(R.id.category_title)
        var image_id = iteview.findViewById<ImageView>(R.id.category_image)
        var card_view = iteview.findViewById<MaterialCardView>(R.id.ctegory_card_view)


    }
}