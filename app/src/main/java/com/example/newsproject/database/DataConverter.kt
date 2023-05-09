package com.example.newsproject.database

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
import java.util.*


class DataConverter {

        @TypeConverter
        fun toLBitArray(urToImage:Bitmap): ByteArray {
            val outBut = ByteArrayOutputStream()
            urToImage.compress(Bitmap.CompressFormat.PNG,100,outBut)
            return outBut.toByteArray()

        }
        @TypeConverter
        fun toBitMapy(url: ByteArray):Bitmap{
           return   BitmapFactory.decodeByteArray(url, 0, url.size)
        }
}