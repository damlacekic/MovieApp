package com.damla.intershipproject2

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.squareup.picasso.Picasso

@BindingAdapter("loadingImage")
fun ImageView.loadImage(moviePhoto:String?){
    this.load("https://image.tmdb.org/t/p/original" + moviePhoto)
}

//@BindingAdapter("loadingImage")
//fun ImageView.loadImage(url: String) {
//    Picasso.get().load(url).into(this)
//}

//@BindingAdapter("ToString")
//fun (rate : Double): String {
//    return rate.toString()
//}