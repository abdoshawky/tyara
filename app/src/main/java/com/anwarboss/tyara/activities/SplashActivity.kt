package com.anwarboss.tyara.activities

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.anwarboss.tyara.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
//
//        planeIV.setBackgroundResource(R.drawable.plane_animation)
//
//        (planeIV.background as AnimationDrawable).start()



        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
//        Handler().postDelayed({
//        }, 1000)
    }
}
