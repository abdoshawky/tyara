package com.anwarboss.tyara.utils

import android.widget.ImageView
import ss.com.bannerslider.ImageLoadingService
import com.squareup.picasso.Picasso

class PicassoImageLoadingService : ImageLoadingService {

    override fun loadImage(url: String, imageView: ImageView) {
        Picasso.get().load(url).into(imageView)
    }

    override fun loadImage(resource: Int, imageView: ImageView) {
        Picasso.get().load(resource).resize(1000,1000).into(imageView)
    }

    override fun loadImage(url: String, placeHolder: Int, errorDrawable: Int, imageView: ImageView) {
        Picasso.get().load(url).placeholder(placeHolder).error(errorDrawable).into(imageView)
    }

}