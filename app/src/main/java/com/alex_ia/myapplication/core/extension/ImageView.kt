package com.alex_ia.myapplication.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.alex_ia.myapplication.R

@BindingAdapter("loadFromURLCircular")
fun ImageView.loadFromURLCircular(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_cooking_food)
    transformations(CircleCropTransformation())
}

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_cooking_food)
}