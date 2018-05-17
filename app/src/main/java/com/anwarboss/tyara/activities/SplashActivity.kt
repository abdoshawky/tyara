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
        setContentView(R.layout.activity_splash)

        supportActionBar!!.hide()

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, 1000)
    }
}
