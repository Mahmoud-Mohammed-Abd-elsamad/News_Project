package com.example.newsproject.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.newsproject.R
import com.example.newsproject.model.Category
import com.example.newsproject.ui.Categories.CategoriesFragment
import com.example.newsproject.ui.News.NewsFragment
import java.util.*

class HomeActivity : AppCompatActivity() {



    lateinit var drawerLayout: DrawerLayout
    lateinit var menu_button:View
    lateinit var categories_button:View
    lateinit var settings_button:View
     var categoriesFragment = CategoriesFragment()
    var newsFragment=NewsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        IntViews()



        categoriesFragment.onclicCategoryLisner = object :CategoriesFragment.OnClicCategoryLisnere{
            override fun onCategoryClic(category: Category) {
                Log.e("OnClicOnCHome","DONE 3")
                PushFragment(NewsFragment.getinstanse(category), addToBackStack = true)
            }

        }

    }

    private fun IntViews() {

        categories_button = findViewById(R.id.categories_button)
        settings_button = findViewById(R.id.settings_botton)
        drawerLayout = findViewById(R.id.drawer_layout)
        menu_button = findViewById(R.id.menu_button)
        PushFragment(categoriesFragment)
        menu_button.setOnClickListener {
            drawerLayout.open()

        }

        categories_button.setOnClickListener {
            PushFragment(CategoriesFragment())
            drawerLayout.close()
        }
        settings_button.setOnClickListener {
            PushFragment(SettingsFragment())
        }

        }


    private fun PushFragment(fragment: Fragment,addToBackStack:Boolean = false) {
       val fragmentTransActoin = supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container,fragment)
               if (addToBackStack){
                   fragmentTransActoin.addToBackStack(" ")
               }
            fragmentTransActoin.commit()

    }
}
