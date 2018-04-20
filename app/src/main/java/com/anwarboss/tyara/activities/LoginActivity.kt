package com.anwarboss.tyara.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwarboss.tyara.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBTN.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            login()
        }

        registerBTN.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

    }

    private fun login() {
        val username = usernameET.text.toString().trim()
        val password = passwordET.text.toString().trim()
    }

}
