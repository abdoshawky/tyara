package com.anwarboss.tyara.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwarboss.tyara.R
import com.anwarboss.tyara.utils.Arrays
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val image = intent.extras.getInt("image")
        val index = intent.extras.getInt("index")

        println(index)
        Picasso.get().load(image).resize(1000,1000).into(imageView)


        val desc = Arrays.photosArray[index]
        descTV.text = desc
    }
}
