package com.damla.intershipproject2

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("loadingImage")
fun ImageView.loadImage(moviePhoto:String?){
    this.load("https://image.tmdb.org/t/p/original" + moviePhoto)
}
