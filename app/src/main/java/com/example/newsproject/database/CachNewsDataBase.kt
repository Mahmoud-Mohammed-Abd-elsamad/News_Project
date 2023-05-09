package com.example.newsproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsproject.model.ArticlesItem
import com.example.newsproject.model.ArticlesItemModel
import com.example.newsproject.model.SourceItem


@Database(entities = [ArticlesItemModel::class,SourceItem::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class CachNewsDataBase : RoomDatabase() {

    abstract fun dao_news(): NewsDao ///>>>>>>>>>>>>>>>>>>>>>> polimarfism>> 3shan anady 3la el Dao men class MyDataBase

    companion object {
        val DATABASENAME = "news_dataBase"

        var myCachNewsDataBasw: CachNewsDataBase? = null


        fun init(context: Context) {
            /// Singleton pattern
            if (myCachNewsDataBasw == null) {
                myCachNewsDataBasw = Room.databaseBuilder(
                    context,
                    CachNewsDataBase::class.java, DATABASENAME
                ).fallbackToDestructiveMigration()
                    //.allowMainThreadQueries()
                    .build()
            }

        }

        fun getInstanse(): CachNewsDataBase {
            return myCachNewsDataBasw!!
        }
    }
}
