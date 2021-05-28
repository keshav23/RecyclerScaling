package com.example.recyclerviewscaling

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop


fun ImageView.loadImage(src: String, round: Boolean) {
    val request = Glide.with(this).load(src)

    val scaleTransformation: BitmapTransformation? = if (round) {
        CircleCrop()
    } else null

    val transformationList = ArrayList<Transformation<Bitmap>>().apply {
        scaleTransformation?.let { add(it) }
    }

    val allTransformations =
        if (transformationList.isNotEmpty()) MultiTransformation(transformationList) else null

    allTransformations?.let {
        request.optionalTransform(it)
    }

    request.into(this)
}

fun ImageView.loadProfilePic(src: String) {
    loadImage(src, true)
}