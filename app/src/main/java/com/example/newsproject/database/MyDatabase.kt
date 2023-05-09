package com.example.newsproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsproject.model.ArticlesItem
import com.example.newsproject.model.SourcesItem


@Database(entities = [SourcesItem::class], version = 1, exportSchema = false)

abstract  class MyDataBase: RoomDatabase(){

   abstract fun dao_sources(): SourcesDao ///>>>>>>>>>>>>>>>>>>>>>> polimarfism>> 3shan anady 3la el Dao men class MyDataBase


    companion object {

        var myDataBase: MyDataBase? = null
        val DATABASENAME = "atabase-name"


        fun init(context:Context) {
            /// Singleton pattern
            if (myDataBase == null) {
                myDataBase = Room.databaseBuilder(
                    context,
                    MyDataBase::class.java, DATABASENAME
                ).fallbackToDestructiveMigration()
                    //.allowMainThreadQueries()
                    .build()
            }

        }
         fun getInstanse():MyDataBase{
             return myDataBase!!
         }
    }
}
