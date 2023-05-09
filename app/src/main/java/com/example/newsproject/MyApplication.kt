package com.example.newsproject

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.newsproject.Api.Constants
import com.example.newsproject.database.CachNewsDataBase
import com.example.newsproject.database.MyDataBase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MyDataBase.init(this)
       CachNewsDataBase.init(this)

        val networkHandler = object : NetworkHandler {
            @RequiresApi(Build.VERSION_CODES.M)
            override suspend fun isOnlion(): Boolean {
                Log.e("netWorkAvilable",""+netWorKAvilable())
                return netWorKAvilable()
            }
        }
        Constants.networkHandler = networkHandler
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun netWorKAvilable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
        return false

    }
}


