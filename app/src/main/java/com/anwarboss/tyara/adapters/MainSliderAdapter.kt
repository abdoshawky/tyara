package com.anwarboss.tyara.adapters

import com.anwarboss.tyara.R
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder


class MainSliderAdapter : SliderAdapter() {

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindImageSlide(position: Int, viewHolder: ImageSlideViewHolder) {
        when (position) {
            0 -> viewHolder.bindImageSlide(R.drawable.rsz_one)
            1 -> viewHolder.bindImageSlide(R.drawable.rsz_two)
            2 -> viewHolder.bindImageSlide(R.drawable.rsz_three)
            3 -> viewHolder.bindImageSlide(R.drawable.rsz_four)
            4 -> viewHolder.bindImageSlide(R.drawable.rsz_five)
            5 -> viewHolder.bindImageSlide(R.drawable.rsz_six)
            6 -> viewHolder.bindImageSlide(R.drawable.rsz_seven)
            7 -> viewHolder.bindImageSlide(R.drawable.rsz_eight)
            8 -> viewHolder.bindImageSlide(R.drawable.rsz_nine)
            9 -> viewHolder.bindImageSlide(R.drawable.rsz_ten)
            10 -> viewHolder.bindImageSlide(R.drawable.rsz_eleven)
            11 -> viewHolder.bindImageSlide(R.drawable.rsz_twelve)
        }
    }

}
