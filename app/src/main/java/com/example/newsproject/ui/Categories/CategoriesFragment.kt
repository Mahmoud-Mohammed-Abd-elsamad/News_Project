package com.example.newsproject.ui.Categories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsproject.R
import com.example.newsproject.model.Category

class CategoriesFragment : Fragment() {



    lateinit var recyclerView: RecyclerView


     val categorieslist = listOf(
    Category("sports",R.string.Sports, R.drawable.sport_icon,R.color.read),
    Category("general",R.string.Politics,R.drawable.politics_icon,R.color.blue), Category(" health",R.string.Health,R.drawable.health_icon,R.color.color_health),
    Category(" business",R.string.Business,R.drawable.business_icon,R.color.color_business),
    Category("science",R.string.Science,R.drawable.sicence_icon,R.color.color_scince),
    Category("technology",R.string.Enviroment,R.drawable.enviroment_icon,R.color.color_enviroment))
    var adapter = CategoryAdapter(categorieslist)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       recyclerView = view.findViewById(R.id.fragment_catehores_resycler_view)
        recyclerView.adapter = adapter

    adapter.onClicLisnerInterface = object: CategoryAdapter.OnClicLisnerInterface {
        override fun onItemclic(position: Int, category: Category) {
            onclicCategoryLisner?.onCategoryClic(category)
        }


    }




        }

    var  onclicCategoryLisner : OnClicCategoryLisnere? = null
    interface OnClicCategoryLisnere {
        fun onCategoryClic(category: Category)

    }

}
