package com.example.newsproject.ui.News

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:imageUrl")
fun setImage(image:ImageView, url:String?) {
    Glide.with(image).load(url).into(image)

}

